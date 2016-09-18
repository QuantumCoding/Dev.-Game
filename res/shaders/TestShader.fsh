#version 330

in vec3 colPos;
out vec4 color;

void main() {
	color = vec4(colPos, 1);
}