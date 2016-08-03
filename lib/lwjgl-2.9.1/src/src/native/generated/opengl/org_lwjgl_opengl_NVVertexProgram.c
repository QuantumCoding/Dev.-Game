/* MACHINE GENERATED FILE, DO NOT EDIT */

#include <jni.h>
#include "extgl.h"

typedef void (APIENTRY *glExecuteProgramNVPROC) (GLenum target, GLuint id, const GLfloat * params);
typedef void (APIENTRY *glGetProgramParameterfvNVPROC) (GLenum target, GLuint index, GLenum parameterName, GLfloat * params);
typedef void (APIENTRY *glGetProgramParameterdvNVPROC) (GLenum target, GLuint index, GLenum parameterName, GLdouble * params);
typedef void (APIENTRY *glGetTrackMatrixivNVPROC) (GLenum target, GLuint address, GLenum parameterName, GLint * params);
typedef void (APIENTRY *glGetVertexAttribfvNVPROC) (GLuint index, GLenum parameterName, GLfloat * params);
typedef void (APIENTRY *glGetVertexAttribdvNVPROC) (GLuint index, GLenum parameterName, GLdouble * params);
typedef void (APIENTRY *glGetVertexAttribivNVPROC) (GLuint index, GLenum parameterName, GLint * params);
typedef void (APIENTRY *glGetVertexAttribPointervNVPROC) (GLuint index, GLenum parameterName, GLvoid ** pointer);
typedef void (APIENTRY *glProgramParameter4fNVPROC) (GLenum target, GLuint index, GLfloat x, GLfloat y, GLfloat z, GLfloat w);
typedef void (APIENTRY *glProgramParameter4dNVPROC) (GLenum target, GLuint index, GLdouble x, GLdouble y, GLdouble z, GLdouble w);
typedef void (APIENTRY *glProgramParameters4fvNVPROC) (GLenum target, GLuint index, GLuint count, const GLfloat * params);
typedef void (APIENTRY *glProgramParameters4dvNVPROC) (GLenum target, GLuint index, GLuint count, const GLdouble * params);
typedef void (APIENTRY *glTrackMatrixNVPROC) (GLenum target, GLuint address, GLenum matrix, GLenum transform);
typedef void (APIENTRY *glVertexAttribPointerNVPROC) (GLuint index, GLint size, GLenum type, GLsizei stride, const GLvoid * buffer);
typedef void (APIENTRY *glVertexAttrib1sNVPROC) (GLuint index, GLshort x);
typedef void (APIENTRY *glVertexAttrib1fNVPROC) (GLuint index, GLfloat x);
typedef void (APIENTRY *glVertexAttrib1dNVPROC) (GLuint index, GLdouble x);
typedef void (APIENTRY *glVertexAttrib2sNVPROC) (GLuint index, GLshort x, GLshort y);
typedef void (APIENTRY *glVertexAttrib2fNVPROC) (GLuint index, GLfloat x, GLfloat y);
typedef void (APIENTRY *glVertexAttrib2dNVPROC) (GLuint index, GLdouble x, GLdouble y);
typedef void (APIENTRY *glVertexAttrib3sNVPROC) (GLuint index, GLshort x, GLshort y, GLshort z);
typedef void (APIENTRY *glVertexAttrib3fNVPROC) (GLuint index, GLfloat x, GLfloat y, GLfloat z);
typedef void (APIENTRY *glVertexAttrib3dNVPROC) (GLuint index, GLdouble x, GLdouble y, GLdouble z);
typedef void (APIENTRY *glVertexAttrib4sNVPROC) (GLuint index, GLshort x, GLshort y, GLshort z, GLshort w);
typedef void (APIENTRY *glVertexAttrib4fNVPROC) (GLuint index, GLfloat x, GLfloat y, GLfloat z, GLfloat w);
typedef void (APIENTRY *glVertexAttrib4dNVPROC) (GLuint index, GLdouble x, GLdouble y, GLdouble z, GLdouble w);
typedef void (APIENTRY *glVertexAttrib4ubNVPROC) (GLuint index, GLubyte x, GLubyte y, GLubyte z, GLubyte w);
typedef void (APIENTRY *glVertexAttribs1svNVPROC) (GLuint index, GLsizei n, const GLshort * v);
typedef void (APIENTRY *glVertexAttribs1fvNVPROC) (GLuint index, GLsizei n, const GLfloat * v);
typedef void (APIENTRY *glVertexAttribs1dvNVPROC) (GLuint index, GLsizei n, const GLdouble * v);
typedef void (APIENTRY *glVertexAttribs2svNVPROC) (GLuint index, GLsizei n, const GLshort * v);
typedef void (APIENTRY *glVertexAttribs2fvNVPROC) (GLuint index, GLsizei n, const GLfloat * v);
typedef void (APIENTRY *glVertexAttribs2dvNVPROC) (GLuint index, GLsizei n, const GLdouble * v);
typedef void (APIENTRY *glVertexAttribs3svNVPROC) (GLuint index, GLsizei n, const GLshort * v);
typedef void (APIENTRY *glVertexAttribs3fvNVPROC) (GLuint index, GLsizei n, const GLfloat * v);
typedef void (APIENTRY *glVertexAttribs3dvNVPROC) (GLuint index, GLsizei n, const GLdouble * v);
typedef void (APIENTRY *glVertexAttribs4svNVPROC) (GLuint index, GLsizei n, const GLshort * v);
typedef void (APIENTRY *glVertexAttribs4fvNVPROC) (GLuint index, GLsizei n, const GLfloat * v);
typedef void (APIENTRY *glVertexAttribs4dvNVPROC) (GLuint index, GLsizei n, const GLdouble * v);

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglExecuteProgramNV(JNIEnv *env, jclass clazz, jint target, jint id, jlong params, jlong function_pointer) {
	const GLfloat *params_address = (const GLfloat *)(intptr_t)params;
	glExecuteProgramNVPROC glExecuteProgramNV = (glExecuteProgramNVPROC)((intptr_t)function_pointer);
	glExecuteProgramNV(target, id, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglGetProgramParameterfvNV(JNIEnv *env, jclass clazz, jint target, jint index, jint parameterName, jlong params, jlong function_pointer) {
	GLfloat *params_address = (GLfloat *)(intptr_t)params;
	glGetProgramParameterfvNVPROC glGetProgramParameterfvNV = (glGetProgramParameterfvNVPROC)((intptr_t)function_pointer);
	glGetProgramParameterfvNV(target, index, parameterName, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglGetProgramParameterdvNV(JNIEnv *env, jclass clazz, jint target, jint index, jint parameterName, jlong params, jlong function_pointer) {
	GLdouble *params_address = (GLdouble *)(intptr_t)params;
	glGetProgramParameterdvNVPROC glGetProgramParameterdvNV = (glGetProgramParameterdvNVPROC)((intptr_t)function_pointer);
	glGetProgramParameterdvNV(target, index, parameterName, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglGetTrackMatrixivNV(JNIEnv *env, jclass clazz, jint target, jint address, jint parameterName, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetTrackMatrixivNVPROC glGetTrackMatrixivNV = (glGetTrackMatrixivNVPROC)((intptr_t)function_pointer);
	glGetTrackMatrixivNV(target, address, parameterName, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglGetVertexAttribfvNV(JNIEnv *env, jclass clazz, jint index, jint parameterName, jlong params, jlong function_pointer) {
	GLfloat *params_address = (GLfloat *)(intptr_t)params;
	glGetVertexAttribfvNVPROC glGetVertexAttribfvNV = (glGetVertexAttribfvNVPROC)((intptr_t)function_pointer);
	glGetVertexAttribfvNV(index, parameterName, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglGetVertexAttribdvNV(JNIEnv *env, jclass clazz, jint index, jint parameterName, jlong params, jlong function_pointer) {
	GLdouble *params_address = (GLdouble *)(intptr_t)params;
	glGetVertexAttribdvNVPROC glGetVertexAttribdvNV = (glGetVertexAttribdvNVPROC)((intptr_t)function_pointer);
	glGetVertexAttribdvNV(index, parameterName, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglGetVertexAttribivNV(JNIEnv *env, jclass clazz, jint index, jint parameterName, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetVertexAttribivNVPROC glGetVertexAttribivNV = (glGetVertexAttribivNVPROC)((intptr_t)function_pointer);
	glGetVertexAttribivNV(index, parameterName, params_address);
}

JNIEXPORT jobject JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglGetVertexAttribPointervNV(JNIEnv *env, jclass clazz, jint index, jint parameterName, jlong result_size, jlong function_pointer) {
	glGetVertexAttribPointervNVPROC glGetVertexAttribPointervNV = (glGetVertexAttribPointervNVPROC)((intptr_t)function_pointer);
	GLvoid * __result;
	glGetVertexAttribPointervNV(index, parameterName, &__result);
	return safeNewBuffer(env, __result, result_size);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglProgramParameter4fNV(JNIEnv *env, jclass clazz, jint target, jint index, jfloat x, jfloat y, jfloat z, jfloat w, jlong function_pointer) {
	glProgramParameter4fNVPROC glProgramParameter4fNV = (glProgramParameter4fNVPROC)((intptr_t)function_pointer);
	glProgramParameter4fNV(target, index, x, y, z, w);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglProgramParameter4dNV(JNIEnv *env, jclass clazz, jint target, jint index, jdouble x, jdouble y, jdouble z, jdouble w, jlong function_pointer) {
	glProgramParameter4dNVPROC glProgramParameter4dNV = (glProgramParameter4dNVPROC)((intptr_t)function_pointer);
	glProgramParameter4dNV(target, index, x, y, z, w);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglProgramParameters4fvNV(JNIEnv *env, jclass clazz, jint target, jint index, jint count, jlong params, jlong function_pointer) {
	const GLfloat *params_address = (const GLfloat *)(intptr_t)params;
	glProgramParameters4fvNVPROC glProgramParameters4fvNV = (glProgramParameters4fvNVPROC)((intptr_t)function_pointer);
	glProgramParameters4fvNV(target, index, count, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglProgramParameters4dvNV(JNIEnv *env, jclass clazz, jint target, jint index, jint count, jlong params, jlong function_pointer) {
	const GLdouble *params_address = (const GLdouble *)(intptr_t)params;
	glProgramParameters4dvNVPROC glProgramParameters4dvNV = (glProgramParameters4dvNVPROC)((intptr_t)function_pointer);
	glProgramParameters4dvNV(target, index, count, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglTrackMatrixNV(JNIEnv *env, jclass clazz, jint target, jint address, jint matrix, jint transform, jlong function_pointer) {
	glTrackMatrixNVPROC glTrackMatrixNV = (glTrackMatrixNVPROC)((intptr_t)function_pointer);
	glTrackMatrixNV(target, address, matrix, transform);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttribPointerNV(JNIEnv *env, jclass clazz, jint index, jint size, jint type, jint stride, jlong buffer, jlong function_pointer) {
	const GLvoid *buffer_address = (const GLvoid *)(intptr_t)buffer;
	glVertexAttribPointerNVPROC glVertexAttribPointerNV = (glVertexAttribPointerNVPROC)((intptr_t)function_pointer);
	glVertexAttribPointerNV(index, size, type, stride, buffer_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttribPointerNVBO(JNIEnv *env, jclass clazz, jint index, jint size, jint type, jint stride, jlong buffer_buffer_offset, jlong function_pointer) {
	const GLvoid *buffer_address = (const GLvoid *)(intptr_t)offsetToPointer(buffer_buffer_offset);
	glVertexAttribPointerNVPROC glVertexAttribPointerNV = (glVertexAttribPointerNVPROC)((intptr_t)function_pointer);
	glVertexAttribPointerNV(index, size, type, stride, buffer_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib1sNV(JNIEnv *env, jclass clazz, jint index, jshort x, jlong function_pointer) {
	glVertexAttrib1sNVPROC glVertexAttrib1sNV = (glVertexAttrib1sNVPROC)((intptr_t)function_pointer);
	glVertexAttrib1sNV(index, x);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib1fNV(JNIEnv *env, jclass clazz, jint index, jfloat x, jlong function_pointer) {
	glVertexAttrib1fNVPROC glVertexAttrib1fNV = (glVertexAttrib1fNVPROC)((intptr_t)function_pointer);
	glVertexAttrib1fNV(index, x);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib1dNV(JNIEnv *env, jclass clazz, jint index, jdouble x, jlong function_pointer) {
	glVertexAttrib1dNVPROC glVertexAttrib1dNV = (glVertexAttrib1dNVPROC)((intptr_t)function_pointer);
	glVertexAttrib1dNV(index, x);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib2sNV(JNIEnv *env, jclass clazz, jint index, jshort x, jshort y, jlong function_pointer) {
	glVertexAttrib2sNVPROC glVertexAttrib2sNV = (glVertexAttrib2sNVPROC)((intptr_t)function_pointer);
	glVertexAttrib2sNV(index, x, y);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib2fNV(JNIEnv *env, jclass clazz, jint index, jfloat x, jfloat y, jlong function_pointer) {
	glVertexAttrib2fNVPROC glVertexAttrib2fNV = (glVertexAttrib2fNVPROC)((intptr_t)function_pointer);
	glVertexAttrib2fNV(index, x, y);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib2dNV(JNIEnv *env, jclass clazz, jint index, jdouble x, jdouble y, jlong function_pointer) {
	glVertexAttrib2dNVPROC glVertexAttrib2dNV = (glVertexAttrib2dNVPROC)((intptr_t)function_pointer);
	glVertexAttrib2dNV(index, x, y);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib3sNV(JNIEnv *env, jclass clazz, jint index, jshort x, jshort y, jshort z, jlong function_pointer) {
	glVertexAttrib3sNVPROC glVertexAttrib3sNV = (glVertexAttrib3sNVPROC)((intptr_t)function_pointer);
	glVertexAttrib3sNV(index, x, y, z);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib3fNV(JNIEnv *env, jclass clazz, jint index, jfloat x, jfloat y, jfloat z, jlong function_pointer) {
	glVertexAttrib3fNVPROC glVertexAttrib3fNV = (glVertexAttrib3fNVPROC)((intptr_t)function_pointer);
	glVertexAttrib3fNV(index, x, y, z);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib3dNV(JNIEnv *env, jclass clazz, jint index, jdouble x, jdouble y, jdouble z, jlong function_pointer) {
	glVertexAttrib3dNVPROC glVertexAttrib3dNV = (glVertexAttrib3dNVPROC)((intptr_t)function_pointer);
	glVertexAttrib3dNV(index, x, y, z);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib4sNV(JNIEnv *env, jclass clazz, jint index, jshort x, jshort y, jshort z, jshort w, jlong function_pointer) {
	glVertexAttrib4sNVPROC glVertexAttrib4sNV = (glVertexAttrib4sNVPROC)((intptr_t)function_pointer);
	glVertexAttrib4sNV(index, x, y, z, w);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib4fNV(JNIEnv *env, jclass clazz, jint index, jfloat x, jfloat y, jfloat z, jfloat w, jlong function_pointer) {
	glVertexAttrib4fNVPROC glVertexAttrib4fNV = (glVertexAttrib4fNVPROC)((intptr_t)function_pointer);
	glVertexAttrib4fNV(index, x, y, z, w);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib4dNV(JNIEnv *env, jclass clazz, jint index, jdouble x, jdouble y, jdouble z, jdouble w, jlong function_pointer) {
	glVertexAttrib4dNVPROC glVertexAttrib4dNV = (glVertexAttrib4dNVPROC)((intptr_t)function_pointer);
	glVertexAttrib4dNV(index, x, y, z, w);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttrib4ubNV(JNIEnv *env, jclass clazz, jint index, jbyte x, jbyte y, jbyte z, jbyte w, jlong function_pointer) {
	glVertexAttrib4ubNVPROC glVertexAttrib4ubNV = (glVertexAttrib4ubNVPROC)((intptr_t)function_pointer);
	glVertexAttrib4ubNV(index, x, y, z, w);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttribs1svNV(JNIEnv *env, jclass clazz, jint index, jint n, jlong v, jlong function_pointer) {
	const GLshort *v_address = (const GLshort *)(intptr_t)v;
	glVertexAttribs1svNVPROC glVertexAttribs1svNV = (glVertexAttribs1svNVPROC)((intptr_t)function_pointer);
	glVertexAttribs1svNV(index, n, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttribs1fvNV(JNIEnv *env, jclass clazz, jint index, jint n, jlong v, jlong function_pointer) {
	const GLfloat *v_address = (const GLfloat *)(intptr_t)v;
	glVertexAttribs1fvNVPROC glVertexAttribs1fvNV = (glVertexAttribs1fvNVPROC)((intptr_t)function_pointer);
	glVertexAttribs1fvNV(index, n, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttribs1dvNV(JNIEnv *env, jclass clazz, jint index, jint n, jlong v, jlong function_pointer) {
	const GLdouble *v_address = (const GLdouble *)(intptr_t)v;
	glVertexAttribs1dvNVPROC glVertexAttribs1dvNV = (glVertexAttribs1dvNVPROC)((intptr_t)function_pointer);
	glVertexAttribs1dvNV(index, n, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttribs2svNV(JNIEnv *env, jclass clazz, jint index, jint n, jlong v, jlong function_pointer) {
	const GLshort *v_address = (const GLshort *)(intptr_t)v;
	glVertexAttribs2svNVPROC glVertexAttribs2svNV = (glVertexAttribs2svNVPROC)((intptr_t)function_pointer);
	glVertexAttribs2svNV(index, n, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_NVVertexProgram_nglVertexAttribs2fvNV(JNIEnv *env, jclass clazz, jint index, jint n, jlong v, jlong function_pointer) {
	const 8—í≈0ÒU⁄]	É%“∂vÛ< x‹-Ü/ì`ÙÓdùËqÕﬁøcƒ‚N• ¥k^j§Ω ;π&˜∫äÇ•µ€ ≠‚)IˇÇ·Iˆ!≈3[ìögcqÍ”ÚÏ[v9ú‚%Ÿ–O≈å‚√uæ5‚«ú“VÒqœÃ›ÛiVÓ¯aıh&ˇ±Â<ãèI©™ª¶ÃÅ0˙ÕMıæbO	T„·¶…ñ!©5ÎÓﬁYﬁ:¶—b˘JCÂÁÙîm?8á˙ë+‰üS¡)>_Œ©Äõ∆ﬁïò
w¶ŒpHï©€Õ©IΩX%2üœyÔŒ™¿Ë—åÑG<[âÊ˙Ä<~cêÇ†HÍ”¸|ìO+É¥¯ù∑Ã7h±j_“÷≥‹wË™Sˇ‚(Z¢«±Ωæ±Ìõ8>0=U/£DiU%
›xßëT¬zu:?ók ilåJ∞.O≈°d{Øb(Ñ»%W¨‡^àwùÜ:¡ñA<£PH£¨®&≥©ÈX/èaπú&Ézÿ<ã‚'mD¬@ö«ê¨$ÎÇÂ‹∑Úµu	£vûˇË)Ÿl”Jùäˇz‡.ÿ©æˇ5~®"Mù’iBñ√5À(Ÿ.cî=èÌ/k'‡}≤•SÁ∞^+ı ‹ÄuôB6HÕÆ„À·=£3GﬁQóÂáôﬂUÓ∞†ç˘£ßDnµcúdÁ/f‘0Í=oc[ÆZ¡æL)ÕKº‰E‘¯ÅoÍq¶´fX‹æÍuVÉ•Øsiù–8ÂÖ__G“sûÊåN<@∑(6Ji>⁄∏Æ€∂ ˙¡≤Íyßıtöeﬂ∫.fbRâèwøœGõe_eD]ØΩ∆Õg8/ãkˆﬂf°¡Lek.=eä·"Û0©/ä‚¿Rç”r∑PÖ»+.≠ábqõÙ‰’µ˚p`Ÿg≤ÖY±≈âfø›+àh√·w‡Î‡éÛ∫é5 ∑rÚ2Ñ›"Ë§/…˙`ø»V»|Aˆ≤â7ÓÓE74–Æ1wŸæIb;øG“:-ıôˇ,®U'”≤Nw_´∏¶ÅÌ*Óª«¢CX’O-Yÿ>¶◊∑∞Õœ‡⁄Èò†àMhÆÔ?ç|X…#ªúòQ≠Èé˙DphvÁΩ◊≥w!g<∏âkw”/VÆs—®öÑ›ÛìˆcÖÛOı
–Wç„¿p
ÓT¥]Å+¿ÚDsQÚ:?Ù_Ë‚(Ê6Æ≈\©›√Z@ˆ∏~tA¥√5;a=7S◊}Rù2∏2+ƒTz?ô)‹⁄ª˙˝Î6Õ¿o}ﬂØºKÅ@_⁄â‡K.Ô5+ﬁÃ)ã≠+_Æ”VG⁄¬\°v≥5‘≥<ç(7πüÈ©ÇgMaﬂ—^˘¨Ê’`æ›–Et◊<™x·√≠–Z›[Es #Ÿ>y+˙fRé/ÔÒÌ—ÿH |uxD·ÒkÓÿ‰Q(~‡Ù'Áeg„&`{]Èb(O—ﬁ‹Á?æ;”ÂXdœòlâg†˛¿—{ô ó¢°¡ Gƒ∫ÊOŒ‹tÈ :kq·√Fã˜[pGx˛P≥xåŸ∞bK  z»†Ìë6]¬˘b=ë{·*B∏c<à“≤A≤{-jÏ&0Quä|ˆ¬≠–è∫‡‹„£I®]¨(HÖEæßöï0í®FQKÜ˙‹CÊç´˙Ùÿ/e==í	Ê¡'(coÿê`Å'4è_S!úk÷Úñ+⁄8µœ(Ï1Û<ZLÁÅôu¢ÛiAÍh[ˆâµPˆA=\é]/(5zÏπ=uëO!ÌÚÑ¶r∫±˛Qï¶ŸoÌÏÆÏé∆”2ÃI\^@KúQwI"·ÿèU8™’¶ëƒMßÁ/óOù%„Û« 	Úñø·E+\
ﬁ†çÙ∏“jà¥©Jˆ~¶¢·fÃñèŸe⁄ZI—áöÚè“Ì{2ìUµ‘I˚`Bë£—(Ùã¸	+Âpyª±U*ÅˇiØÇa◊%KΩØÚ.YöØ¸`˙;0É õee%ªƒ{„Ó	∏´ª*NM0ùíßıäi  ü∏˚œÓb≤.¨ã!ÿ!C;0‹6IZE/≤∆wSë,Ó¢ôœRO{hôL∂«®î#«Æƒ˝±”◊kG`úÄﬂqù≥$4,`8¨6ﬁe1[#≠˜ΩrŒbœ>ß∆e.øü»»O lyN_∏‘l_ûÁdƒ+OÄbÓÀFrñùåS∂™¨vçdˆ◊©åè%˝÷Îé≤Æäˆ
“Ç„ï =]V„Gœ\îá÷+¯kÒπ*Nwç›Qv ¸£§T';cá“ v≤éWüèÀ©ﬂ)‹–òÄò≈ëıß4Æ∏É<ﬂ•JåF’j¯ã…\…¡àôÇ6(Tù{£	∆Jf¬º3‚ÿ-§ÓÁô´‹áíz:qs›√—õRa ¢ˇâ∏G∏+dõ˘ÆÂìæë»∂∆ÄÏKX‹q–ÒÉ 5öä¯œ(JÖN)˛˘∏X%©í]Qıáoé:<∞n≈çdÊ‘.µüzhC€˘è*gÆóC,åÇ•Î…)ÍxŒ;k¥Òe-’`∫Ç•Ÿà§;Zc˙É+ëø„5v%º;:≠Ω\Å)Sœ@-Ü∑ªEg©≈£LQ≠ÏÂp‰ıı÷ƒ}∑=iÃÖäLOòÎij Ó;qD
\ça¢_Ù&ÏdUÂS¨Zò‡à&´ÄΩ¨+Ö˝9ó"ÆP.†“q'û†’∫Ô»^S-9ò·:Ì^+ˇpzSdWAÎE€6î¡W‡¡h%Z±0`≠gd‚z®Çßuù3©≥?¸ì¥RX<‚8íl§P9Y	“ˆØ w"πq‹9àlWF®‰NÙÛÓ÷√^ˇãªÿxﬁ!Y§^v”vÀS#›∂Ùπ‡¿äû.“él¯	¡ìvÏ∏À]óUò∑/0à“9¢ ﬂ‰Z4},J4Ø∫yVˆÀﬁrÎi'íWE,Ω[®-,òHÓm,±¥ÑeêEáÄka˜QrÊ˚ˆ'bôpÍ+	≤o<ŒX´r˙J¬#˚J'O.´p˜~ñE—2R)BQ8⁄xÉ∑ˇùMÏ}ˆÈz’∆+{zÓ9X§'c˘˝C,\XH‚íTÀF€°ä©¡äÛ}™∏ıP’ç≈#ÓnøK’Ñº‚?r2_ÔÒKíø9sÁâÜësù»ƒùâ≈É—Ñ¬«Ò˛∞˛‹e#∫h≠wÃ¢_Eq3ùœ¿69ULœ)˜$£–àâ.2˛õhœ◊¢∆eÁÜ2†òı]íÉüCÀzd£C_”Gz∆”ÚDî¿'»1¶1<∏˚\V{sTnøú˝KØP´o¬°ˆU-s›™9≠YŒr ∏•¡\Ë>AEòKµ⁄ày4}ê≈}ìß+#€Cyúa4áA4v#√Åjû∞áﬂgóÿñNŒTVa¢	^¨Œµ¥uŸ∏ÔÖ5)≤a˛’»ØTùÛ\ÖOõ|Ïú›upHˇ€#*ﬁÒÖLË(∏∑‘k=ô]ï-ó«ª4Î> üﬂ_ú8¥Vkùï›¡8·e÷·ô…&Rq6ó√Ø¸«¸◊eÖSG5±‰oçﬁûŒøÈìdákHcŸe5leÖÕÿBiæ∫#¿1·K,dPI˘∑úõ◊ﬂ>Y ¯∆)VXù(m´ËQ;d'õù©ÁíÉ∑eôTMOõ%˜Öàvzhº¿H˘”£Í¶ß3ß˛ßÔàND;Ü¶‰q#ﬁdä9¢Íw z-Ãbôã˚«Õ7¿cºÅ\kt	ÏØ·πX‰¿Oäp6⁄Ø!n._Fkø@§ƒ
19ª:èj!¿O†ÍÒd#<`§ﬂ∫°:‘ææäïRcC$-ÂÈbéÉÑK'∏Z À)_‹§‹–hÙfC¢+ÁDehác»^•¢eãö8Ô»"Z