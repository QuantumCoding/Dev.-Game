#version 140

in vec2 textureCoord1;
in vec2 textureCoord2;
in float blend;

out vec4 out_colour;

uniform sampler2D texture0;

void main(void) {

	vec4 sample1 = texture(texture0, textureCoord1);
	vec4 sample2 = texture(texture0, textureCoord2);

	out_colour = mix(sample1, sample2, blend);

}