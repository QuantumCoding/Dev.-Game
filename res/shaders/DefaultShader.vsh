#version 400 core
#define LIGHT_COUNT 4

in vec3 position;
in vec2 texCoord;
in vec3 normal;

out vec2 texCoordPass;
out vec3 surfaceNormal;

out vec3 toLightVector[LIGHT_COUNT];
out vec3 toCameraVector;
out float visibility; 

uniform mat4 transformationMatrix;
uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;

uniform float numberOfRows;
uniform vec2 offset;

uniform vec3 lightPosition[LIGHT_COUNT];

uniform float fogDensity;
uniform float fogGradient;

void main(void) {
	vec4 worldPosition = transformationMatrix * vec4(position, 1.0);
	vec4 positionRelativeToCam = viewMatrix * worldPosition;
	gl_Position = projectionMatrix * positionRelativeToCam;

	float distanceFromCam = length(positionRelativeToCam.xyz);
	visibility = exp(-pow((distanceFromCam*fogDensity), fogGradient));
	visibility = clamp(visibility, 0.0, 1.0);
	
	texCoordPass = (texCoord / numberOfRows) + offset;
	surfaceNormal = (transformationMatrix * vec4(normal, 0.0)).xyz;
	for(int i=0; i<LIGHT_COUNT; i++) {
		toLightVector[i] = lightPosition[i] - worldPosition.xyz;
	}
	toCameraVector = (inverse(viewMatrix) * vec4(0, 0, 0, 1)).xyz - worldPosition.xyz;
}