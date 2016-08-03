#version 400 core

in vec4 color;

out vec4 outColor;

//uniform sampler2D texture0;

void main() {
	outColor = color; //vec4(1, 0, 0, 1);
}