#include <GL/glew.h>
#include <GL/freeglut.h>
#include <vector>
#include <string>
#include <fstream>
#include <sstream>
#include <glm/gtc/matrix_transform.hpp>
#include <iostream>

using namespace std;

GLuint VertexBufferID;
GLuint LoadShaders(const char* vertex_file_path, const char* fragment_file_path);
GLuint programID;

GLuint MatrixID;

glm::mat4 Projection;
glm::mat4 View;
glm::mat4 Model;
glm::mat4 mvp;

float angle;

void timer(int value)
{
	angle = angle + glm::radians(5.0f);
	glutPostRedisplay();
	glutTimerFunc(20, timer, 0);
}
void transform()
{
	Model = glm::mat4(1.0f);// Model matrix : an identity matrix (model will be at the origin)
							//4X4 Identity matrix
	Model = glm::rotate(Model, angle, glm::vec3(0, 1, 0));
	//회전축은 0,1,0. 즉, y축 회전이다

	mvp = Projection * View*Model;
	//homogeneous maxtrix를 이용해 하나의 matrix로 만들어낸다
	glUniformMatrix4fv(MatrixID, 1, GL_FALSE, &mvp[0][0]);
}

std::vector<glm::vec3> vertices;
void mydisplay() {
	transform();

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	glEnableVertexAttribArray(0);
	glBindBuffer(GL_ARRAY_BUFFER, VertexBufferID);
	glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, (void*)0);

	glDrawArrays(GL_TRIANGLES, 0, 3*vertices.size()*sizeof(glm::vec3));
	// Starting from vertex 0; 3 vertices -> 1 triangle
	glDisableVertexAttribArray(0);
	glutSwapBuffers();
}
void init()
{
	MatrixID = glGetUniformLocation(programID, "MVP");
	glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	GLuint VertexArrayID;
	glGenVertexArrays(1, &VertexArrayID);
	glBindVertexArray(VertexArrayID); 
	glGenBuffers(1, &VertexBufferID);
	glBindBuffer(GL_ARRAY_BUFFER, VertexBufferID);
	glBufferData(GL_ARRAY_BUFFER, vertices.size()*sizeof(glm::vec3), &vertices[0], GL_STATIC_DRAW);
	programID = LoadShaders("simple.vshader", "simple.fshader");
	glUseProgram(programID);
}

GLuint LoadShaders(const char* vertex_file_path, const char* fragment_file_path) {

	// Create the shaders
	GLuint VertexShaderID = glCreateShader(GL_VERTEX_SHADER);
	GLuint FragmentShaderID = glCreateShader(GL_FRAGMENT_SHADER);

	// Read the Vertex Shader code from the file
	std::string VertexShaderCode;
	std::ifstream VertexShaderStream(vertex_file_path, std::ios::in);
	if (VertexShaderStream.is_open()) {
		std::stringstream sstr;
		sstr << VertexShaderStream.rdbuf();
		VertexShaderCode = sstr.str();
		VertexShaderStream.close();
	}
	else {
		printf("Impossible to open %s. Are you in the right directory ? Don't forget to read the FAQ !\n", vertex_file_path);
		getchar();
		return 0;
	}
	// Read the Fragment Shader code from the file
	std::string FragmentShaderCode;
	std::ifstream FragmentShaderStream(fragment_file_path, std::ios::in);
	if (FragmentShaderStream.is_open()) {
		std::stringstream sstr;
		sstr << FragmentShaderStream.rdbuf();
		FragmentShaderCode = sstr.str();
		FragmentShaderStream.close();
	}
	GLint Result = GL_FALSE;
	int InfoLogLength;

	// Compile Vertex Shader
	printf("Compiling shader : %s\n", vertex_file_path);
	char const* VertexSourcePointer = VertexShaderCode.c_str();
	glShaderSource(VertexShaderID, 1, &VertexSourcePointer, NULL);
	glCompileShader(VertexShaderID);

	// Check Vertex Shader
	glGetShaderiv(VertexShaderID, GL_COMPILE_STATUS, &Result);
	glGetShaderiv(VertexShaderID, GL_INFO_LOG_LENGTH, &InfoLogLength);
	if (InfoLogLength > 0) {
		std::vector<char> VertexShaderErrorMessage(InfoLogLength + 1);
		glGetShaderInfoLog(VertexShaderID, InfoLogLength, NULL, &VertexShaderErrorMessage[0]);
		printf("%s\n", &VertexShaderErrorMessage[0]);
	}

	// Compile Fragment Shader
	printf("Compiling shader : %s\n", fragment_file_path);
	char const* FragmentSourcePointer = FragmentShaderCode.c_str();
	glShaderSource(FragmentShaderID, 1, &FragmentSourcePointer, NULL);
	glCompileShader(FragmentShaderID);

	// Check Fragment Shader
	glGetShaderiv(FragmentShaderID, GL_COMPILE_STATUS, &Result);
	glGetShaderiv(FragmentShaderID, GL_INFO_LOG_LENGTH, &InfoLogLength);
	if (InfoLogLength > 0) {
		std::vector<char> FragmentShaderErrorMessage(InfoLogLength + 1);
		glGetShaderInfoLog(FragmentShaderID, InfoLogLength, NULL, &FragmentShaderErrorMessage[0]);
		printf("%s\n", &FragmentShaderErrorMessage[0]);
	}
	// Link the program
	printf("Linking program\n");
	GLuint ProgramID = glCreateProgram();
	glAttachShader(ProgramID, VertexShaderID);
	glAttachShader(ProgramID, FragmentShaderID);
	glLinkProgram(ProgramID);

	// Check the program
	glGetProgramiv(ProgramID, GL_LINK_STATUS, &Result);
	glGetProgramiv(ProgramID, GL_INFO_LOG_LENGTH, &InfoLogLength);
	if (InfoLogLength > 0) {
		std::vector<char> ProgramErrorMessage(InfoLogLength + 1);
		glGetProgramInfoLog(ProgramID, InfoLogLength, NULL, &ProgramErrorMessage[0]);
		printf("%s\n", &ProgramErrorMessage[0]);
	}

	glDetachShader(ProgramID, VertexShaderID);
	glDetachShader(ProgramID, FragmentShaderID);

	glDeleteShader(VertexShaderID);
	glDeleteShader(FragmentShaderID);

	return ProgramID;
}
void myreshape(int w, int h) {
	glViewport(0, 0, w, h);

	Projection = glm::perspective(glm::radians(45.0f),
		(float)w / (float)h, 0.1f, 100.0f);
	//Projection = glm::ortho(-10.0f,10.0f,-10.0f,10.0f,0.0f,100.0f);
	//4x4 matrix를 만들어준다
	View = glm::lookAt(
		glm::vec3(0, 0, 15), // Camera is at (0,0,3), in World Space
		glm::vec3(0, 0, 0), // and looks at the origin
		glm::vec3(0, 1, 0)  // Head is up (set to 0,-1,0 to look upside-down)
	);//viewing transformation을 해준다
	transform();
}
bool loadOBJ(const char* path, std::vector<glm::vec3>& vertices)
{
	std::vector<unsigned int> vertexIndices;
	std::vector<glm::vec3> temp_vertices;

	FILE* file = NULL;

	if (fopen_s(&file, path, "r") != NULL) {
		printf("File can't be opened\n");
		return false;
	}

	while (true) {
		char lineHeader[128];
		// read the first word of the line
		if (fscanf_s(file, "%s", lineHeader, 128) == EOF)
			break; // EOF = End Of File. Quit the loop.

				   // else : parse lineHeader
		if (strcmp(lineHeader, "v") == 0) {
			glm::vec3 vertex;
			fscanf_s(file, "%f %f %f\n", &vertex.x, &vertex.y, &vertex.z);
			temp_vertices.push_back(vertex);
		}

		else if (strcmp(lineHeader, "f") == 0) {
			unsigned int vertexIndex[3];
			int matches = fscanf_s(file, "%d %d %d\n", &vertexIndex[0], &vertexIndex[1], &vertexIndex[2]);
			if (matches != 3) {
				printf("File can't be read\n");
				return false;
			}
			vertexIndices.push_back(vertexIndex[0]);
			vertexIndices.push_back(vertexIndex[1]);
			vertexIndices.push_back(vertexIndex[2]);
		}
	}
	fclose(file);
	for (unsigned int i = 0; i < vertexIndices.size(); i++) {
		unsigned int vertexIndex = vertexIndices[i];
		glm::vec3 vertex = temp_vertices[vertexIndex - 1];
		vertices.push_back(vertex);
	}
}



int main(int argc, char** argv)
{
	cout << "어떤 오브젝트를 구현하고싶나요?? " << endl;
	cout << "1. tetrahedron  " << "2. teapot  " << "3. bones " << endl;
	int N;
	cin >> N;
	if (N == 1)//tetrahedron일때
	{
		loadOBJ("tetrahedron.obj", vertices);
	}
	else if (N == 2)
	{
		loadOBJ("teapot.obj", vertices);
	}
	else
	{
		loadOBJ("bones.obj", vertices);
	}
	glutInit(&argc, argv);
	glutInitWindowSize(400, 400);
	glutInitWindowPosition(500, 500);
	glutCreateWindow("[과제3]17101214배진환");
	glutInitDisplayMode(GLUT_DEPTH | GLUT_DOUBLE | GLUT_RGBA);
	glutTimerFunc(0, timer, 0);
	glutDisplayFunc(mydisplay);
	glutReshapeFunc(myreshape);
	GLenum err = glewInit();
	if (err == GLEW_OK) {
		init();
		glutMainLoop();
	}
}
