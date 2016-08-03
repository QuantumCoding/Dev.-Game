#version 400 core

in vec3 position;
in vec2 texCoord;

out vec2 texCoordPass;

uniform mat4 depthMatrix;

void main(void) {
	gl_Position = depthMatrix * vec4(position, 1);
	texCoordPass = texCoord;
}