#version 400 core

in vec2 texCoordPass;
in vec3 surfaceNormal;

out vec4 color_out;

uniform sampler2D texture0;

void main(void) {
	color_out = texture(texture0, texCoordPass + (surfaceNormal * 0).xy);
}