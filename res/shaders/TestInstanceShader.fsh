#version 400 core

in vec3 colorOff;
in vec2 texCoordPass;
in vec3 surfaceNormal;

out vec4 color_out;

uniform sampler2D texture0;

void main(void) {
	color_out = texture(texture0, texCoordPass + (surfaceNormal * 0).xy);
	color_out = mix(color_out, vec4(colorOff, 1), 0);
}