#version 400 core

in vec2 position;
in vec4 modelViewMatrix0;
in vec4 modelViewMatrix1;
in vec4 modelViewMatrix2;
in vec4 modelViewMatrix3;

in vec4 modelViewMatrix4;
in vec4 modelViewMatrix5;
in vec4 modelViewMatrix6;
in vec4 modelViewMatrix7;

out vec4 color;

uniform mat4 projectionMatrix;

mat4 getIdenity() {
	mat4 idnt;
	
	idnt[0][0] = 1;
	idnt[1][1] = 1;
	idnt[2][2] = 1;
	idnt[3][3] = 1;
	
	return idnt;
}

void main() {
	mat4 modelViewMatrix;
	modelViewMatrix[0] = modelViewMatrix0;
	//modelViewMatrix[1] = modelViewMatrix1;
	//modelViewMatrix[2] = modelViewMatrix2;
	//modelViewMatrix[3] = modelViewMatrix3;
	
	vec4 cameraSpaceSave = modelViewMatrix * vec4(position, -1, 1);
	vec4 cameraSpace = getIdenity() * vec4(position, -1, 1);
	gl_Position = projectionMatrix * cameraSpace;
	
	color = vec4(
		(modelViewMatrix0.x + modelViewMatrix4.x) / 2, 
		(modelViewMatrix1.y + modelViewMatrix5.y) / 2, 
		(modelViewMatrix2.z + modelViewMatrix6.z) / 2, 
		(modelViewMatrix3.w + modelViewMatrix7.w) / 2).xyz + vec4(0, 0, 0, 1);
	//color = modelViewMatrix * vec4(1);
	//color = vec4(modelViewMatrix[3][0], 
				 //modelViewMatrix[3][1], 
				// modelViewMatrix[3][2], 
				// modelViewMatrix[3][3]);
}