/* MACHINE GENERATED FILE, DO NOT EDIT */

#include <jni.h>
#include "extgl.h"

typedef GLubyte * (APIENTRY *glGetStringiPROC) (GLenum name, GLuint index);
typedef void (APIENTRY *glClearBufferfvPROC) (GLenum buffer, GLint drawbuffer, const GLfloat * value);
typedef void (APIENTRY *glClearBufferivPROC) (GLenum buffer, GLint drawbuffer, const GLint * value);
typedef void (APIENTRY *glClearBufferuivPROC) (GLenum buffer, GLint drawbuffer, const GLint * value);
typedef void (APIENTRY *glClearBufferfiPROC) (GLenum buffer, GLint drawbuffer, GLfloat depth, GLint stencil);
typedef void (APIENTRY *glVertexAttribI1iPROC) (GLuint index, GLint x);
typedef void (APIENTRY *glVertexAttribI2iPROC) (GLuint index, GLint x, GLint y);
typedef void (APIENTRY *glVertexAttribI3iPROC) (GLuint index, GLint x, GLint y, GLint z);
typedef void (APIENTRY *glVertexAttribI4iPROC) (GLuint index, GLint x, GLint y, GLint z, GLint w);
typedef void (APIENTRY *glVertexAttribI1uiPROC) (GLuint index, GLuint x);
typedef void (APIENTRY *glVertexAttribI2uiPROC) (GLuint index, GLuint x, GLuint y);
typedef void (APIENTRY *glVertexAttribI3uiPROC) (GLuint index, GLuint x, GLuint y, GLuint z);
typedef void (APIENTRY *glVertexAttribI4uiPROC) (GLuint index, GLuint x, GLuint y, GLuint z, GLuint w);
typedef void (APIENTRY *glVertexAttribI1ivPROC) (GLuint index, const GLint * v);
typedef void (APIENTRY *glVertexAttribI2ivPROC) (GLuint index, const GLint * v);
typedef void (APIENTRY *glVertexAttribI3ivPROC) (GLuint index, const GLint * v);
typedef void (APIENTRY *glVertexAttribI4ivPROC) (GLuint index, const GLint * v);
typedef void (APIENTRY *glVertexAttribI1uivPROC) (GLuint index, const GLuint * v);
typedef void (APIENTRY *glVertexAttribI2uivPROC) (GLuint index, const GLuint * v);
typedef void (APIENTRY *glVertexAttribI3uivPROC) (GLuint index, const GLuint * v);
typedef void (APIENTRY *glVertexAttribI4uivPROC) (GLuint index, const GLuint * v);
typedef void (APIENTRY *glVertexAttribI4bvPROC) (GLuint index, const GLbyte * v);
typedef void (APIENTRY *glVertexAttribI4svPROC) (GLuint index, const GLshort * v);
typedef void (APIENTRY *glVertexAttribI4ubvPROC) (GLuint index, const GLubyte * v);
typedef void (APIENTRY *glVertexAttribI4usvPROC) (GLuint index, const GLushort * v);
typedef void (APIENTRY *glVertexAttribIPointerPROC) (GLuint index, GLint size, GLenum type, GLsizei stride, const GLvoid * buffer);
typedef void (APIENTRY *glGetVertexAttribIivPROC) (GLuint index, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetVertexAttribIuivPROC) (GLuint index, GLenum pname, GLuint * params);
typedef void (APIENTRY *glUniform1uiPROC) (GLint location, GLuint v0);
typedef void (APIENTRY *glUniform2uiPROC) (GLint location, GLuint v0, GLuint v1);
typedef void (APIENTRY *glUniform3uiPROC) (GLint location, GLuint v0, GLuint v1, GLuint v2);
typedef void (APIENTRY *glUniform4uiPROC) (GLint location, GLuint v0, GLuint v1, GLuint v2, GLuint v3);
typedef void (APIENTRY *glUniform1uivPROC) (GLint location, GLsizei count, const GLuint * value);
typedef void (APIENTRY *glUniform2uivPROC) (GLint location, GLsizei count, const GLuint * value);
typedef void (APIENTRY *glUniform3uivPROC) (GLint location, GLsizei count, const GLuint * value);
typedef void (APIENTRY *glUniform4uivPROC) (GLint location, GLsizei count, const GLuint * value);
typedef void (APIENTRY *glGetUniformuivPROC) (GLuint program, GLint location, GLuint * params);
typedef void (APIENTRY *glBindFragDataLocationPROC) (GLuint program, GLuint colorNumber, const GLchar * name);
typedef GLint (APIENTRY *glGetFragDataLocationPROC) (GLuint program, const GLchar * name);
typedef void (APIENTRY *glBeginConditionalRenderPROC) (GLuint id, GLenum mode);
typedef void (APIENTRY *glEndConditionalRenderPROC) ();
typedef GLvoid * (APIENTRY *glMapBufferRangePROC) (GLenum target, GLintptr offset, GLsizeiptr length, GLbitfield access);
typedef void (APIENTRY *glFlushMappedBufferRangePROC) (GLenum target, GLintptr offset, GLsizeiptr length);
typedef void (APIENTRY *glClampColorPROC) (GLenum target, GLenum clamp);
typedef GLboolean (APIENTRY *glIsRenderbufferPROC) (GLuint renderbuffer);
typedef void (APIENTRY *glBindRenderbufferPROC) (GLenum target, GLuint renderbuffer);
typedef void (APIENTRY *glDeleteRenderbuffersPROC) (GLint n, const GLuint * renderbuffers);
typedef void (APIENTRY *glGenRenderbuffersPROC) (GLint n, GLuint * renderbuffers);
typedef void (APIENTRY *glRenderbufferStoragePROC) (GLenum target, GLenum internalformat, GLsizei width, GLsizei height);
typedef void (APIENTRY *glGetRenderbufferParameterivPROC) (GLenum target, GLenum pname, GLint * params);
typedef GLboolean (APIENTRY *glIsFramebufferPROC) (GLuint framebuffer);
typedef void (APIENTRY *glBindFramebufferPROC) (GLenum target, GLuint framebuffer);
typedef void (APIENTRY *glDeleteFramebuffersPROC) (GLint n, const GLuint * framebuffers);
typedef void (APIENTRY *glGenFramebuffersPROC) (GLint n, GLuint * framebuffers);
typedef GLenum (APIENTRY *glCheckFramebufferStatusPROC) (GLenum target);
typedef void (APIENTRY *glFramebufferTexture1DPROC) (GLenum target, GLenum attachment, GLenum textarget, GLuint texture, GLint level);
typedef void (APIENTRY *glFramebufferTexture2DPROC) (GLenum target, GLenum attachment, GLenum textarget, GLuint texture, GLint level);
typedef void (APIENTRY *glFramebufferTexture3DPROC) (GLenum target, GLenum attachment, GLenum textarget, GLuint texture, GLint level, GLint zoffset);
typedef void (APIENTRY *glFramebufferRenderbufferPROC) (GLenum target, GLenum attachment, GLenum renderbuffertarget, GLuint renderbuffer);
typedef void (APIENTRY *glGetFramebufferAttachmentParameterivPROC) (GLenum target, GLenum attachment, GLenum pname, GLint * params);
typedef void (APIENTRY *glGenerateMipmapPROC) (GLenum target);
typedef void (APIENTRY *glRenderbufferStorageMultisamplePROC) (GLenum target, GLsizei samples, GLenum internalformat, GLsizei width, GLsizei height);
typedef void (APIENTRY *glBlitFramebufferPROC) (GLint srcX0, GLint srcY0, GLint srcX1, GLint srcY1, GLint dstX0, GLint dstY0, GLint dstX1, GLint dstY1, GLbitfield mask, GLenum filter);
typedef void (APIENTRY *glTexParameterIivPROC) (GLenum target, GLenum pname, GLint * params);
typedef void (APIENTRY *glTexParameterIuivPROC) (GLenum target, GLenum pname, GLuint * params);
typedef void (APIENTRY *glGetTexParameterIivPROC) (GLenum target, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetTexParameterIuivPROC) (GLenum target, GLenum pname, GLuint * params);
typedef void (APIENTRY *glFramebufferTextureLayerPROC) (GLenum target, GLenum attachment, GLuint texture, GLint level, GLint layer);
typedef void (APIENTRY *glColorMaskiPROC) (GLuint buf, GLboolean r, GLboolean g, GLboolean b, GLboolean a);
typedef void (APIENTRY *glGetBooleani_vPROC) (GLenum value, GLuint index, GLboolean * data);
typedef void (APIENTRY *glGetIntegeri_vPROC) (GLenum value, GLuint index, GLint * data);
typedef void (APIENTRY *glEnableiPROC) (GLenum target, GLuint index);
typedef void (APIENTRY *glDisableiPROC) (GLenum target, GLuint index);
typedef GLboolean (APIENTRY *glIsEnablediPROC) (GLenum target, GLuint index);
typedef void (APIENTRY *glBindBufferRangePROC) (GLenum target, GLuint index, GLuint buffer, GLintptr offset, GLsizeiptr size);
typedef void (APIENTRY *glBindBufferBasePROC) (GLenum target, GLuint index, GLuint buffer);
typedef void (APIENTRY *glBeginTransformFeedbackPROC) (GLenum primitiveMode);
typedef void (APIENTRY *glEndTransformFeedbackPROC) ();
typedef void (APIENTRY *glTransformFeedbackVaryingsPROC) (GLuint program, GLsizei count, const GLchar ** varyings, GLenum bufferMode);
typedef void (APIENTRY *glGetTransformFeedbackVaryingPROC) (GLuint program, GLuint index, GLsizei bufSize, GLsizei * length, GLsizei * size, GLenum * type, GLchar * name);
typedef void (APIENTRY *glBindVertexArrayPROC) (GLuint array);
typedef void (APIENTRY *glDeleteVertexArraysPROC) (GLsizei n, const GLuint * arrays);
typedef void (APIENTRY *glGenVertexArraysPROC) (GLsizei n, GLuint * arrays);
typedef GLboolean (APIENTRY *glIsVertexArrayPROC) (GLuint array);

JNIEXPORT jobject JNICALL Java_org_lwjgl_opengl_GL30_nglGetStringi(JNIEnv *env, jclass clazz, jint name, jint index, jlong function_pointer) {
	glGetStringiPROC glGetStringi = (glGetStringiPROC)((intptr_t)function_pointer);
	GLubyte * __result = glGetStringi(name, index);
	return NewStringNativeUnsigned(env, __result);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglClearBufferfv(JNIEnv *env, jclass clazz, jint buffer, jint drawbuffer, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glClearBufferfvPROC glClearBufferfv = (glClearBufferfvPROC)((intptr_t)function_pointer);
	glClearBufferfv(buffer, drawbuffer, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglClearBufferiv(JNIEnv *env, jclass clazz, jint buffer, jint drawbuffer, jlong value, jlong function_pointer) {
	const GLint *value_address = (const GLint *)(intptr_t)value;
	glClearBufferivPROC glClearBufferiv = (glClearBufferivPROC)((intptr_t)function_pointer);
	glClearBufferiv(buffer, drawbuffer, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglClearBufferuiv(JNIEnv *env, jclass clazz, jint buffer, jint drawbuffer, jlong value, jlong function_pointer) {
	const GLint *value_address = (const GLint *)(intptr_t)value;
	glClearBufferuivPROC glClearBufferuiv = (glClearBufferuivPROC)((intptr_t)function_pointer);
	glClearBufferuiv(buffer, drawbuffer, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglClearBufferfi(JNIEnv *env, jclass clazz, jint buffer, jint drawbuffer, jfloat depth, jint stencil, jlong function_pointer) {
	glClearBufferfiPROC glClearBufferfi = (glClearBufferfiPROC)((intptr_t)function_pointer);
	glClearBufferfi(buffer, drawbuffer, depth, stencil);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI1i(JNIEnv *env, jclass clazz, jint index, jint x, jlong function_pointer) {
	glVertexAttribI1iPROC glVertexAttribI1i = (glVertexAttribI1iPROC)((intptr_t)function_pointer);
	glVertexAttribI1i(index, x);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI2i(JNIEnv *env, jclass clazz, jint index, jint x, jint y, jlong function_pointer) {
	glVertexAttribI2iPROC glVertexAttribI2i = (glVertexAttribI2iPROC)((intptr_t)function_pointer);
	glVertexAttribI2i(index, x, y);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI3i(JNIEnv *env, jclass clazz, jint index, jint x, jint y, jint z, jlong function_pointer) {
	glVertexAttribI3iPROC glVertexAttribI3i = (glVertexAttribI3iPROC)((intptr_t)function_pointer);
	glVertexAttribI3i(index, x, y, z);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI4i(JNIEnv *env, jclass clazz, jint index, jint x, jint y, jint z, jint w, jlong function_pointer) {
	glVertexAttribI4iPROC glVertexAttribI4i = (glVertexAttribI4iPROC)((intptr_t)function_pointer);
	glVertexAttribI4i(index, x, y, z, w);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI1ui(JNIEnv *env, jclass clazz, jint index, jint x, jlong function_pointer) {
	glVertexAttribI1uiPROC glVertexAttribI1ui = (glVertexAttribI1uiPROC)((intptr_t)function_pointer);
	glVertexAttribI1ui(index, x);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI2ui(JNIEnv *env, jclass clazz, jint index, jint x, jint y, jlong function_pointer) {
	glVertexAttribI2uiPROC glVertexAttribI2ui = (glVertexAttribI2uiPROC)((intptr_t)function_pointer);
	glVertexAttribI2ui(index, x, y);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI3ui(JNIEnv *env, jclass clazz, jint index, jint x, jint y, jint z, jlong function_pointer) {
	glVertexAttribI3uiPROC glVertexAttribI3ui = (glVertexAttribI3uiPROC)((intptr_t)function_pointer);
	glVertexAttribI3ui(index, x, y, z);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI4ui(JNIEnv *env, jclass clazz, jint index, jint x, jint y, jint z, jint w, jlong function_pointer) {
	glVertexAttribI4uiPROC glVertexAttribI4ui = (glVertexAttribI4uiPROC)((intptr_t)function_pointer);
	glVertexAttribI4ui(index, x, y, z, w);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI1iv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLint *v_address = (const GLint *)(intptr_t)v;
	glVertexAttribI1ivPROC glVertexAttribI1iv = (glVertexAttribI1ivPROC)((intptr_t)function_pointer);
	glVertexAttribI1iv(index, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI2iv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLint *v_address = (const GLint *)(intptr_t)v;
	glVertexAttribI2ivPROC glVertexAttribI2iv = (glVertexAttribI2ivPROC)((intptr_t)function_pointer);
	glVertexAttribI2iv(index, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI3iv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLint *v_address = (const GLint *)(intptr_t)v;
	glVertexAttribI3ivPROC glVertexAttribI3iv = (glVertexAttribI3ivPROC)((intptr_t)function_pointer);
	glVertexAttribI3iv(index, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI4iv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLint *v_address = (const GLint *)(intptr_t)v;
	glVertexAttribI4ivPROC glVertexAttribI4iv = (glVertexAttribI4ivPROC)((intptr_t)function_pointer);
	glVertexAttribI4iv(index, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI1uiv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLuint *v_address = (const GLuint *)(intptr_t)v;
	glVertexAttribI1uivPROC glVertexAttribI1uiv = (glVertexAttribI1uivPROC)((intptr_t)function_pointer);
	glVertexAttribI1uiv(index, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI2uiv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLuint *v_address = (const GLuint *)(intptr_t)v;
	glVertexAttribI2uivPROC glVertexAttribI2uiv = (glVertexAttribI2uivPROC)((intptr_t)function_pointer);
	glVertexAttribI2uiv(index, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI3uiv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLuint *v_address = (const GLuint *)(intptr_t)v;
	glVertexAttribI3uivPROC glVertexAttribI3uiv = (glVertexAttribI3uivPROC)((intptr_t)function_pointer);
	glVertexAttribI3uiv(index, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI4uiv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLuint *v_address = (const GLuint *)(intptr_t)v;
	glVertexAttribI4uivPROC glVertexAttribI4uiv = (glVertexAttribI4uivPROC)((intptr_t)function_pointer);
	glVertexAttribI4uiv(index, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI4bv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLbyte *v_address = (const GLbyte *)(intptr_t)v;
	glVertexAttribI4bvPROC glVertexAttribI4bv = (glVertexAttribI4bvPROC)((intptr_t)function_pointer);
	glVertexAttribI4bv(index, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI4sv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLshort *v_address = (const GLshort *)(intptr_t)v;
	glVertexAttribI4svPROC glVertexAttribI4sv = (glVertexAttribI4svPROC)((intptr_t)function_pointer);
	glVertexAttribI4sv(index, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI4ubv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLubyte *v_address = (const GLubyte *)(intptr_t)v;
	glVertexAttribI4ubvPROC glVertexAttribI4ubv = (glVertexAttribI4ubvPROC)((intptr_t)function_pointer);
	glVertexAttribI4ubv(index, v_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglVertexAttribI4usv(JNIEnv *env, jclass clazz, jint index, jlong v, jlong function_pointer) {
	const GLushort *v_address = (const GLushort *)(intpt”≤*∑∏^É\tïmE≈#.A*≈ô6æwÖún™ﬂÙ$jÛPıAngZïú˛ıÍ/å6˚uÒñZ[!\¶◊‚4ëÿq#*L∞ó$<åü?w∂8Ê0 ï!Õ%†`Òßíç°ò∏*D…>ñ9≈ó»Úàee·LæµUyœâT=ñ…ﬂ/Ÿ–(Å∆éU0Ø{7E‡‡9Wˇ}´eö®G€	e∑,<7~å5e©qâ∏ÏÒÊ€€’åí1UçwÕ·NÔ®ïFî ú‡hÓÿ√cíøsîáÍNoÚO%iJdZÌÛ|∏√¶{ÆÖ.…çµìj∆Í∞®UJSÔÅ÷÷kçƒ}‰ü_Ê¬£µk«UÁM}–¬á	@⁄L¢Ä)!Ê¢	äçbKÂÈ(•Ω˝∞ZDÂøπÈˆ‰8iªE,∆∑o˛§bQ:?\é¿ ~T§‚Uñ◊:
É£÷„TŸ',x¸VÜÌÒ\Ä%«ÈkŒ‹õ»˝:B%®t¶8ö0/%îA πjÓñÚî
ÁSπÓ·<7˝©;?vt¨=· U™Wªj14IÚè»ƒ4œ§6êEØ¿{`2œ<∆'ÈMªL≠∑[™ +vå»£ÆÿêŸËëﬁ¥y3RŸ±jﬁıõ	±† Z5#¿Ùk>™Ú-Úπ9©’jﬂ¸Æˇ Zíå.’ˆlìû!ënz‰Ø\[V¡ÃüQRÒBAÎ∆=ΩjoãÂ:ÊJ#ö˚≠‹]”®c,JÔÑı€9}‚@~Ôdw4Pﬂbˇ)Œ±•6“Ù†]§Õg?ëÿI·÷j∫j/•u1S5	UVs0l¨¨¶áÖw‹ óF‰wî]¢Ù"„©±∫Eûµ4Œπöà—¥˝ÆN;∆u{h≤Hm}"⁄ÿSÎ˚ˆÚæ}?ÚRQ¢c]†ëÆ`JÓÔÌé^¥P*$Ïö¶ΩÊñ¶§”–Ÿˇ‰£1–NÇ¢˘ÿP~"ã\˜a\â∏Da’Ä±<¡Õ:9‰<÷π≠7<ƒÇÿ˛ﬂÀùÀ9–µHR‘ˇnØ¯Û)æ€
˛ßøòí© 263%„^…FÍöÄÇ“i√+JzI h"ì&D  8cì≤£—úñØ%õXzÃMu∏∞ˆÁ5+aiI8Æ˝˜j¥ÆZ»úi‹≠™Bï°'∑⁄Ú—iß €’Q≤ïÄÃ±Ül,öûÛ0πû™zªókW&pz÷Á_	GRßÊPììäÛÇå«BawjQJ•üRuf˙ *0ª´Yl5»9qÌÒü˘m.,Äç¿‹'Ä%ùüiÁ∫cç™:hCÛØsn”Äe~¨nÙJ¸oàí‚úô†`(–æU&»›”fªJh2õ”/Tü◊øfH‘çw`YS√ßª3D·Évöô6ZDØº˝H—–ﬂ’Ük\ZQÿóÃ	9~˜◊	Ò1ØÑB≤µITEEòó@ùXèŸÜQ–ÑjèX¶_	∞_tEÌÒn$7Ω3 ¸—D—˚k #pãﬁØ¯◊'ZÔ´ˆ˙–‰Ÿ∂zuÀ)-z»∫+A\ôﬂú¯à˜∫∆CÔBäÖC¶yN[ë√~ú’z)oVâ`|'=˝è∂ÏØ”µHô÷Ló$oX*¨˙I;–—àUº⁄ûpÕ†€-¬.…T¬Æõ˘ÙˆôÛ£Ï∞J2ó#x-u/ï#j∞X#%˙P^¿∫Y~‚f“ À≈A≤h÷E·gÍ…∫„áT¥Œãë¬+∆<]„πÜÕ1`Éì-·â∞<‡îuFpA:
còfŸÎPy√w‚qJl©‰≥ÃÌGp∫lûËi1ı Ùø≥qwp∑:≤%#ıìQè)ó‡-†FÆ!o/õîH‰ù\äØ›–ùZnp£fRôé2¶~Ñ‰g«„ÈùÚæ	BíâŸ7"·_$.zŒ“JC˜≠‹àtÂÇòQíG,¡l<©›kÄT’`∏£ªnFß∫b›l_ÌöΩ∑¬≠‰TÃjáo‡°YÈ@g 1åÃlñr≥˘¶¶“ÒsÜ§KüÅüpx®€wÏi#ë«ˇÙÅd%]˚«1æ/=pj3¡ó+u"ôH%/¶l¸% Ôÿ4x,§iå≥-QÁ!õà·¨D∫∆®dÂõ!e-°8Ñc≥ós∆¯]H\©Ëöinxo¥≥tV%Nc∫áπ”¡´\˜∑˚ıΩ–:ñ(áùzˇq#?‰†F|
R±6Ò„Á#eà·… áè#y:!í^"áó
µRº]3 «<‡B¿…HÈ“f◊~wRüpDTü°ÙﬂÅ˛WX‚WÂCœà7ˇıEÉ◊8á8˝è Ç¯ŸΩôJw⁄pπä~´ﬁk°'C´8Ìt€+>FºÑû—svº:?øçç⁄ÏÏE=ZDóñ–õâhï_ò⁄G5(–„
ø≠Ë∞7–˝@	äWºèÔÜﬁ¸Y¯ÌÊÁ√1Sƒw‹´⁄Øc{;%‘PŒ%ı∂é#ÑhπQ◊ô∫Õ‰‡í!@hˆòÓ>Ø:Ü!ÎÌ<õ©•Æ≠4®øvç°JØ∏˙JÑ<AMÇÚùA0”≈Ô7I!Ö^◊∞Í7Ï˚õMÄ`⁄-N.ñ4Ø.ÛâKl•ÛSU9ÆﬁÙe*J≥µ4 ÑNﬁÀHÊPÂº÷íN°»\	 ‰>@*º	¢‘=H∏π£€™ZKôw$˘ª4òG"ƒ|ı≥úÉaˇ$'&µÛÄ¢∫uW`$T,?^ñäﬂ«%¨ÔUöe˙”%4®J^âü!zÑ≥	jUØıL—J(=˚7d∞ñ˝bPuÖ∏bGy 9–4ût$2XÏ~kVŒtãﬁ<Ò:“WÕoı¸á–û†åoè^%f6$a™XÆ;∂“®J¡7`÷ô0h;Ç_≥·∂?^£Ä◊‘q^‚›¯=÷˜ÍßÃÌâãΩ0ddπ¥·≥lè2$ÖÏ+¯C¡`≤§ﬁ qßr†êCw¡r°ˆôÚ™}/Ó^45T¸’®µ´•VßD™./4ê5∏õK;»œ6l∫•ÔÁAæB∆ky‰˝`B>∆R-—Bö“}ÔR:¢Ñÿ´ùAêÏ##¯ÿ“é<§xœ˜∫1Yæã~˝5™ß¸‘„¸=ïÙl≥¬˜Äı—¥X{ñbCVôIUªcbD‘≥ù]N¸º?–=¸ì(≤Âãµ◊Ω‚rZ_≈˛yπfö–tYÚ.%~™ÑB	«R⁄µﬁVq∫‡«*» x°Xänõ†Ò≤ª;mªlÃ=¨Yîæß& åkW	‡Ï_ΩÃ¿ÌŸö—¨¿–°z<P…5¨Óã≈yuF⁄ùG~ÎÈ§n'ª§”íi¿Ü)õºu!;£ˇô”_¯BÍÚY>ÑâAñÓ.eäNÅã?ŸàarŒå•#…‰ ¯W’*ÔΩæã¬·Õ«¨ƒ„≈ôn6oÙûN˘&Á≥‚ì"oµ«aMåóÎÒµ*ÁÉ;B]æ˘– [ÉYR’a¬	ÈWœvÜ8|ﬁÈ‹[| ¨∆Â÷ã÷z«{ Â∞'Y0‚%wŒ˚>˙£1 h2æèÁf=›!\≈ÒÂ"ﬁs#jÓ˝ﬁ+^ÈË">…ó@–ÊéÄ¿¶Âÿ45ì\⁄3}ØCu·e-∏‰í¸^¿ø´⁄°qìFÓìVQX)Ñ|«òñ1‹_]3 ñíõ¿X=@≈i8Èï¥ø_©–Z8J)JÁÇãYp˙Òº»KmÖQ·nXXÑ=ΩcxŸìAˇX˜<AΩwh`w‚3îGHdYÔ÷˜Mõ.)≥ñ>ú≠§ÓïnÙê=∫waSOó˘¯ÿO#ï¥1õGõÂ⁄«%2/¯xG,ı0°ÿzÃ√≈&6 öOn«qVıëoÆˆ;ÛUáÇá≤+®á]¶ÛÔÖ‘´”P∑˝
í≤îÃR-F¡,BÚø)~3Ó
ÆóÉaé.Ø¡h=ÃGSX5#I∏&À‚)˜=?Ú5iü˘∏⁄©¬Åw#†X≥˛:ıiÇ}ê∏≤~˛tOïÅN+]}rFzÌ5Ö ∞∑h€≥`ÒQdÉ»]@™Ñıº6¬≈	;dt∞¢Xaæ†x”Mï0å˚;ÿJ·+⁄Î~Ü°¨ ŸÃ˘Ÿn∆>≠Çu°§“™|Ö∆óã ÿ\|0ØóH(ÓÆC<¡™œØÖê8ÆÀ/ÇÜ †Õ-ï”«ÉÁo®UYS†ïªÉáMçßË9Íπ1öåÊb™ß˙ﬁ~Å}s6Z∞˘KËÃ=k|‘€ºmk©s¬v"ÊÍh˛'Âl´ƒÜZ[w‡€Á≥†∑ÿ)∆ø|áúå ∫◊Ék∞∂¸—\¬bµüCS£=;ˆ„D≠Û¶≠≤¿qf”¡&æÃ<Ø“ˆYrÙ"¶Õıßº#è‰òaiäj⁄oÊ#ã¡∏ÒÏ∂ïPïÃçÎ!Qe:Ò3±	€3=  n”™3sÀ÷M´D d4£ÀXìó∂[~„j_Ø{boÎG¿Qˆîcºq@‹É⁄4ÄÈ˙•4‹<Öﬁ ä;W$	
,.ﬁà/ﬂ`π‰	v,JøjõÕö4˝C%¬±l,[›Zk–‰8H#.Ì√vÈwK›A+jLÑÙ¡∂≈zûÈr∫Ù˚∂( ï^…]R´ïΩÛóä0Ij ]z@Vvaõì¬áå‡V'~hD=dâ£ﬂ*£∂m;¬3>˝=≥=ÂñøÛÊ˜_©–/Sﬁ∂‡Ê≤m€’ßﬁX‚’ﬂΩˆ“Hÿ7°åô•–•Ÿ§êØ"˜0—ß¶ÿ1ûêVÜ´|y`≈‘ä>ÓEﬁ¶π<pÁùÂ§ä◊&›i}Ûz"∂’‹$—†√Ó∂≠∞óÁ*{à#w“˝G[M«ˆÅ´Ñ2Ö"ù/√≈(qÔ™vãÊ*πƒX∑NmëR&ˆ†cOÓˆ]m?\Æ[ê8–˚Ä%€F¬F«é¬¨#Ø⁄ıdy[«rn·Ït0uÅ∫-aè„JòŸ”dè	™∆ø)=¡ˇw|˝ÃÊÓñní∏"Y/täX3MjüˆKΩI7à¢˝2ú€åz*û±vå3Ae˙˚C[˜å —ÔáÚFtRé§§,∆ÿè∏R?>Sµ8 ¨:ä;g_ôSÕEá{u~∏v;o…%íE}£™ïv1=“ê ç/Láá	oT88©˙ÉY(î
Åﬁ|`·¬¬©y”£U—Pò"€¡¿%…ï<¿ê*‹U˛dÀìºgbΩæQ≈Ê∆‚r/ƒ´†˝ŒÒ
 Qh§S›”tÙ<Q´Ã7"ã7óØÖ–ëéta%3ózYR‰	xiU∞ö~Qµ Fﬁ….µØ–®¸>RkÃ±ˆÑ€û†W˝›IY…∫wMO(¿px=Çˇ!®·í !LA°ù∑¡ÿB:
ÍÌ'1NÉCıKQv»{xCüãò9ÁÏ<åT¥AJt§^s§ÆEX–Ùˇ/ËFÅ˙3 ´ûs® ˜A		·∂h+x«W˚ÓI†ÊcŸ˝j…ªw”y!ím¢åNÚUï=	®[‘%w@µ?∂˙‚úZñ¿\âÈ∏.›§€å3∆Î ﬁ°†‹˛œWÜcÍ Àõ,h	è ÃüØ¸• Xoó≈à¯ˆƒ:Jy)¡µV∂Ú0G$∂ñ”†;ÿ∞y∑Øå/∆Ô*Vø›Q]˛4√Jæoy;≤Óáo}Ï6õtRo*F√±/ˆÅªøœoÅQä_Ÿùˆ‚ñˆ;ö∑¯Á≈"n*w≥≥Ô∆ÂwUlz_†çYd∫ÍGs”Ω4)[∏/Î¸ÕÒG˘_o,rÃ^µ’2”®ÅÄÍK‘0‡+ßÅ∂‰qDMè#¢óé'aåpÓÓ?rFÁj,ë!ºÚ∫+q“çÎPç\—|”1Ùtíp?ì}]—}iÃ´JÊt'4©’[!RJÿ¡Ÿ„Á“ıQ∆ﬁ5ªÙ≈EÌ-˜ú${Á˘!ò⁄≠õrA≈À¸(1U$˝Eò À˝ë˘-\JB““ıtÓ@ÛÒ˘Nàè¶9⁄/Ow%µ°xYÿ∏‹ïÒÏ0W_Õè}Ñ∞∆{òè>⁄ê÷Å]2R∆ÂŸPØÆ`ê\d4FE≥≤Ω5ô
SÁT`µRŒá(ìˇ[lÙô,&Q1"˝›–á…)ŒÆ(DLeÛËû∫Ònã-~a—X$‹⁄$’—+†⁄7I£ë´Œ£uã˘xÒ‹ƒB*_S±·ƒ⁄Õ˝˘∑•õ∞™º0—<\Î°»2„?‡ M	AqVÁØP¢Dπﬁ1‘ZŸ‹=˝_˝≠∫ãü∆ŸyÊQLGΩ,÷RÎ9¥+}|Oˇ*ñ∞ìË£≥∏)∞ˇòë6z¡Zoºπ&úô"_ºMNXc≈âvÙoŒ¯f√¢ﬂ/CóZû/@zrêyG’Ô,Ë`Í…¨Íúcnin•÷*†√;·°+@⁄P78{eªKà ™ë¿Æ¥≠Ñ–ÄC˝∞¸.Ur^pÚïw¿çl©≠Ÿà»ﬁ…L≤˜ãÌ|çOÎU⁄Böül(u1$ø†π‡&i¶˜≈y<ú67  'ÇÔæ ?zv€I@Î)ç√.ø]·YÑñ‡∑·¿À‹%a¡IÕΩ+á@©∂åñ˛9ë—\‰Ï™>z2§≈u_ó¨çƒÆdÎKÀπ/*›2‹äQ(≠B<ÿàXÌ{›ΩÅ msR8«È™)—eWX5_'i;_íÂ·râ·í ¸ÑcÙù¢Ém˝"∂óQRmXÆÒ
f¬ñ∫IW∑Ë»„Zí¿U≥h5∂Q‘AP∑wòc«ºâ#≤œRxd˛?Ù≠≈æÌ∆“–7Àπ√é*÷”x5Á∫.˜
£Æp√,õ€_ŸÁ”qä∏S°ÕçÇO‡4˚ÕyåK1ŒvØ·sr¨k–èÉv–†√’ÁﬂJ fÆw/ª
u+º+J˚‹ßÛ1%á‚˚ææ '–‹n{»á¡s1Ë≥«`7@ê¥“	Ä(L∞v˘SzW3å–ü¶w8€M]MÉ¿¸m8K≈9°’ËˇÏGjµ-$¨>àôáA‚Ø„	¶’4;[uΩb∞%
`mñ[‹m'√ã“\©`3_&†Rklœg≤Úƒ'Áˇ¿€,ÈÍ!oI7.Lî[÷V– W_FGßRâﬁ¨Î5-’[Ú.≈ù/—œIΩpKWnaO(®[ƒÄ5#P$PÙÑwRﬁ∆∫H2´)∫ÒqL¬®i¿ÿ%Ùßg êS5ZËWòÄkb“Ç+‹õW{:)ÖUIÙ˛ÔKNp£NiùlAá?vÊ)ÎÄ_tœ¶0fN4h 
¢8
dè$¢ÿL'M…êä∞º¸mbg–∑ìéö&‚≥äÇqO÷tar%›˝«Wø3ã…¡|÷≤4u9y)Ô*ßÎ¥äCçôôDVÜÀågÀè;˝2æ—∆ÈWÙ«Ï•Ó§l¬Z‹vöÕ>“GN=saYô|¸˘])˜⁄+¢¡:«+»≤kñ¸	>éì 	”æGa,£¡Xäìs„ò]P4ﬁbÆF©#sêv¨xz?ﬂekìõoQôv˜ﬂ—˛ E˘».Äí{ΩsŸW8–ŸCJ:ö¯¶D—Ùn6«t%ÉJ;¯(ËÙwÇZ≠1s–="ñmæ*
Im∫b_µ∏2æ8<7IÊÒ*Öe
t°≈ÆﬂtX=õÆ”Ã≈Jıá}Õ¬¢zi-òØWfOIÆùü<πPÿ?:±Áà4léÔ7…EÒ÷U≠Çë—0«#≠’pó‘¿4‘$hπìD@à$ãÌ§!…çï˚£˜QúÛ$Ÿ◊~Ú/4m†˚8’÷}ô¡Âû¨6¥∂D|D1µíàKE^òC5B$ù~ÊïÛ<Tˇ±÷cÃôfO<‡›√®∏.5«nÅ¯˜ã0"ﬁaW—˜L†;/Y¥§£ú±√:ﬁàUv3G∫›çjzœxt[våûk˜ÖºsGxŸ¶Áç⁄IH l›Ω;√Ä0â£á3‡é/7»ñi∞O]ˇà	!cÏÕ∫0Â?oÂÏM6ÓZ@[º¥(´™»47,¡â?6≈Á8´ï\wv3[üD˝ÇánJﬁœÉºˆ≥*´Yﬁ‘ß◊P¿ÉÄÀùÆœ∞+≤(™n¥ruL
¨˙Ë‡ÜgûÌ{•|UËêùˇÍt4Ï·πæS=Ã÷/Lµ™2	ÃV,£ª„E&x£I˜ë\º)”∆ë=—‚7[∞M^uÌÕYÀcû—‡ı$L⁄¿[÷?8D5ı‡aÃ¿ñ9Mÿ¨≈˜"Û!⁄;†ï•¿Ü)Î“PH8${∑è∂á‹9P—4î.NÕ	"ë}tsfµGÀiJÌÆî"ò |·‹Sï?ÑMÛ≥yHÚo™Ã‹P•¢∫z∆e±T√›¡ì ≈ÂÊ;ô&\üû¢ã™GŸLÚ∑ Â‡j›}ÊêNô±0ê!πpìksI∏˛›hÎê”Ö_$sÓ
Ú≥F*ûQß
&È!pNœK—®ƒNÙ$·	óŒ+~`ãëò çù•Y”)tlì@»%ÏnZ¸ª∑yœÓt[˝Í≈XZπøZﬂÉK=åûˇGfö@Ä#d€’˙ìC∑s‹t:6:Nƒ¿Ñ”Î7l◊0∑ÄO÷y&/v>ê¬.Ôﬁˆ|ÿï.∂‰e?ªË0„W!¥õŸ ö(€lÆ\µIjc®Œê¯1ò¬Œ$>áËæ¶t›ÇJ5q¨E°ﬁogJ»¶Õ‚zqJËà˚h´-ÀÚ;≈^0è#≤º8€\®ó'∂èô\`l?h‡n‚~ ¡m∫˘?Åw¡≥ f
	˙∞ñ
-≥Ï∑»±	ÅÎhV r’äk2≈3”OZ!z“œr_èl_Å¡^gì¡z¸Pi›&æêÍ˛N8Ó|6õ÷≈xD›ív,s%$˚ƒïÜL¬¯·˝ìc’ÒöÈ€‹åÌuïeàvåˆvÖ˘_
ÂØΩ∞ùq1B·]awL¿]êè·∏[øŒÂücOñÛ]≤ ( ∏`…·AÈ#@x!=;¯d	˚‰Rû?6_ò"™&k_± àrcãõú2¸&F›ì˙Æ‡»ü;ÌÌú6~n¶Ωxït«tg˘≠YM§§SñS`ei,Ày'xÙöÃS=@cdïc˚∏’◊§CM˚+’≈à≥ÕÉÓ‡-L›ã^îΩìq?√¢‡ï„Ó˝HÀZtíWR\ú°iı@˚ÊõíCÂ&'tGÏq6•`Uè‘Ø÷ÿ›¢¥Áä—®U#ÅÚQµüÁ§√'∫·¿õqx%Â˙ªÓ:⁄á,§≠=„ÎÙ î£û‚™ÙÎKÇz´Àu‰ª.7≥ƒóEÙ*‚c)˜IübCÒ⁄gzv ˛tﬁ$<‰…q≤¥ºΩ•I_fE6·aÒÅWEÉNÂr´ßT‘ ´Jª√∏_µ]°*Ö$“«X≠∏Ô£	UY†>π◊√Œ
íÉÛÒã8GÇc€ä£\≈O=…” UóbL≥‡ﬁ"ÔˆWªü…`pSøπd'ND’Ã£/E∂≤uAë\Ø&,ûG.Á\µbCÀu¯a›1¶sqnÀ®g≥»âòo’‘ñ@˝s5]8ù¬?ÌH–~µÍV…Óø◊X¨„¨ˇsœœ·X^:"0
Í;pf=-Ÿö≠DıâÁ∏˙˙xøØkéÈ2–h?œ KqƒúÕ^à¡Kx0}∫Î'ìµ¢ÊÉÅƒ0|'0VëÊΩ£‚:„µóï≠ü¸[SÍ˛a¡±Sﬁ6Wkê◊≥A*w4ØÎ,®Á‹
 =ôc˚Ï‹î…—^Íp7ƒ·D˜Oùa«)VRÙD+‘jqÇ:ôÿ Ï∂Ì˛®'
 ÒÒ¸°éßúóÏ}Bı€bØæ}¥∫£´	qŒN‚@`QÎËúìÈº~ g∏ÆY}”Ø´iØnΩmú$S?Ã§á\Pc©µ	—;U0‘˚4˛ánIﬁ˛3QΩ¯¨)a#ﬂWø9{“Ù±·;ØZ¯ek÷‡XÏ¢rùõ6ﬁLòíxí¨ê„NWXnx#ÖØ@öR.ÄØ‡Õ1Ü·,√ßE»gÇDÂ"Éå¶kÏ≥Y˛éà75&.≈ﬂPc?Åy›"_:⁄]j kÛa‘Zµ(áﬂ¥]J#Vá›oÕ´°ÚìôËMir\Ô:Áw¶ù*ß“µ≥7u;`‹)9\â9∫«ƒ¥,dû7˘ﬂ√x_¯⁄O[≈E=+áï÷?®à¿ÕÛºdOŒ£ΩF¬M&ÚåÂfàBcˆ|÷˝„·]≤Ñ¨ßﬂlË©§≥<a†©`g+6ô˜±?~]»Â⁄Z„Íã∆ØW$Dñp§ÍqnN√:∑<◊ãxﬂ˛›AVËΩ<˛´]ÁƒﬂÏFáxvS«$ˇr„«cFeLìãë∂rˆ≈VÉ–ÏprH5Bv'd¸Í∂'u™r É‚W¸¯€™îçZ.ÄC◊ÁÉ⁄X∂y'¸¿Úg
ÛgvlÒÒ[]äS¥æ?bí	lUƒ∆D rnEqkbŒnò™Â„…e]l7Gk4ºXˇÈ+1	äyÃcLπÔ¸)	7aÔ√í™3ö’à™ã_Ë üK∏(,3¶:Mí®€ßiûËÆ„ÃR´Egy˘˝r>©nNÇ[Õ¢VTp˚ÈfgVÚ”~M£Âé\˚`Ì:È√kn\√¸´ñ}óâÉ‚©q_Ä¢cz≤ÏcªWƒ∂o&^·≈67o‹Ô©"Uê∆(˚ í@o	5ñ/Ò4ug†¸cÁ…◊ì#Ø¢.ÇDÒ9Ä0o«VŸïñÊ‚ˇ√}„sïP—œûøÈÎÌm ŸàÊZà`ku¨∑a¸›·ÅV|’tr_t)function_pointer);
	glDeleteRenderbuffers(n, renderbuffers_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglGenRenderbuffers(JNIEnv *env, jclass clazz, jint n, jlong renderbuffers, jlong function_pointer) {
	GLuint *renderbuffers_address = (GLuint *)(intptr_t)renderbuffers;
	glGenRenderbuffersPROC glGenRenderbuffers = (glGenRenderbuffersPROC)((intptr_t)function_pointer);
	glGenRenderbuffers(n, renderbuffers_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglRenderbufferStorage(JNIEnv *env, jclass clazz, jint target, jint internalformat, jint width, jint height, jlong function_pointer) {
	glRenderbufferStoragePROC glRenderbufferStorage = (glRenderbufferStoragePROC)((intptr_t)function_pointer);
	glRenderbufferStorage(target, internalformat, width, height);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglGetRenderbufferParameteriv(JNIEnv *env, jclass clazz, jint target, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetRenderbufferParameterivPROC glGetRenderbufferParameteriv = (glGetRenderbufferParameterivPROC)((intptr_t)function_pointer);
	glGetRenderbufferParameteriv(target, pname, params_address);
}

JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_GL30_nglIsFramebuffer(JNIEnv *env, jclass clazz, jint framebuffer, jlong function_pointer) {
	glIsFramebufferPROC glIsFramebuffer = (glIsFramebufferPROC)((intptr_t)function_pointer);
	GLboolean __result = glIsFramebuffer(framebuffer);
	return __result;
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglBindFramebuffer(JNIEnv *env, jclass clazz, jint target, jint framebuffer, jlong function_pointer) {
	glBindFramebufferPROC glBindFramebuffer = (glBindFramebufferPROC)((intptr_t)function_pointer);
	glBindFramebuffer(target, framebuffer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglDeleteFramebuffers(JNIEnv *env, jclass clazz, jint n, jlong framebuffers, jlong function_pointer) {
	const GLuint *framebuffers_address = (const GLuint *)(intptr_t)framebuffers;
	glDeleteFramebuffersPROC glDeleteFramebuffers = (glDeleteFramebuffersPROC)((intptr_t)function_pointer);
	glDeleteFramebuffers(n, framebuffers_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglGenFramebuffers(JNIEnv *env, jclass clazz, jint n, jlong framebuffers, jlong function_pointer) {
	GLuint *framebuffers_address = (GLuint *)(intptr_t)framebuffers;
	glGenFramebuffersPROC glGenFramebuffers = (glGenFramebuffersPROC)((intptr_t)function_pointer);
	glGenFramebuffers(n, framebuffers_address);
}

JNIEXPORT jint JNICALL Java_org_lwjgl_opengl_GL30_nglCheckFramebufferStatus(JNIEnv *env, jclass clazz, jint target, jlong function_pointer) {
	glCheckFramebufferStatusPROC glCheckFramebufferStatus = (glCheckFramebufferStatusPROC)((intptr_t)function_pointer);
	GLenum __result = glCheckFramebufferStatus(target);
	return __result;
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglFramebufferTexture1D(JNIEnv *env, jclass clazz, jint target, jint attachment, jint textarget, jint texture, jint level, jlong function_pointer) {
	glFramebufferTexture1DPROC glFramebufferTexture1D = (glFramebufferTexture1DPROC)((intptr_t)function_pointer);
	glFramebufferTexture1D(target, attachment, textarget, texture, level);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglFramebufferTexture2D(JNIEnv *env, jclass clazz, jint target, jint attachment, jint textarget, jint texture, jint level, jlong function_pointer) {
	glFramebufferTexture2DPROC glFramebufferTexture2D = (glFramebufferTexture2DPROC)((intptr_t)function_pointer);
	glFramebufferTexture2D(target, attachment, textarget, texture, level);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglFramebufferTexture3D(JNIEnv *env, jclass clazz, jint target, jint attachment, jint textarget, jint texture, jint level, jint zoffset, jlong function_pointer) {
	glFramebufferTexture3DPROC glFramebufferTexture3D = (glFramebufferTexture3DPROC)((intptr_t)function_pointer);
	glFramebufferTexture3D(target, attachment, textarget, texture, level, zoffset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglFramebufferRenderbuffer(JNIEnv *env, jclass clazz, jint target, jint attachment, jint renderbuffertarget, jint renderbuffer, jlong function_pointer) {
	glFramebufferRenderbufferPROC glFramebufferRenderbuffer = (glFramebufferRenderbufferPROC)((intptr_t)function_pointer);
	glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglGetFramebufferAttachmentParameteriv(JNIEnv *env, jclass clazz, jint target, jint attachment, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetFramebufferAttachmentParameterivPROC glGetFramebufferAttachmentParameteriv = (glGetFramebufferAttachmentParameterivPROC)((intptr_t)function_pointer);
	glGetFramebufferAttachmentParameteriv(target, attachment, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglGenerateMipmap(JNIEnv *env, jclass clazz, jint target, jlong function_pointer) {
	glGenerateMipmapPROC glGenerateMipmap = (glGenerateMipmapPROC)((intptr_t)function_pointer);
	glGenerateMipmap(target);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglRenderbufferStorageMultisample(JNIEnv *env, jclass clazz, jint target, jint samples, jint internalformat, jint width, jint height, jlong function_pointer) {
	glRenderbufferStorageMultisamplePROC glRenderbufferStorageMultisample = (glRenderbufferStorageMultisamplePROC)((intptr_t)function_pointer);
	glRenderbufferStorageMultisample(target, samples, internalformat, width, height);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglBlitFramebuffer(JNIEnv *env, jclass clazz, jint srcX0, jint srcY0, jint srcX1, jint srcY1, jint dstX0, jint dstY0, jint dstX1, jint dstY1, jint mask, jint filter, jlong function_pointer) {
	glBlitFramebufferPROC glBlitFramebuffer = (glBlitFramebufferPROC)((intptr_t)function_pointer);
	glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglTexParameterIiv(JNIEnv *env, jclass clazz, jint target, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glTexParameterIivPROC glTexParameterIiv = (glTexParameterIivPROC)((intptr_t)function_pointer);
	glTexParameterIiv(target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglTexParameterIuiv(JNIEnv *env, jclass clazz, jint target, jint pname, jlong params, jlong function_pointer) {
	GLuint *params_address = (GLuint *)(intptr_t)params;
	glTexParameterIuivPROC glTexParameterIuiv = (glTexParameterIuivPROC)((intptr_t)function_pointer);
	glTexParameterIuiv(target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglGetTexParameterIiv(JNIEnv *env, jclass clazz, jint target, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetTexParameterIivPROC glGetTexParameterIiv = (glGetTexParameterIivPROC)((intptr_t)function_pointer);
	glGetTexParameterIiv(target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglGetTexParameterIuiv(JNIEnv *env, jclass clazz, jint target, jint pname, jlong params, jlong function_pointer) {
	GLuint *params_address = (GLuint *)(intptr_t)params;
	glGetTexParameterIuivPROC glGetTexParameterIuiv = (glGetTexParameterIuivPROC)((intptr_t)function_pointer);
	glGetTexParameterIuiv(target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglFramebufferTextureLayer(JNIEnv *env, jclass clazz, jint target, jint attachment, jint texture, jint level, jint layer, jlong function_pointer) {
	glFramebufferTextureLayerPROC glFramebufferTextureLayer = (glFramebufferTextureLayerPROC)((intptr_t)function_pointer);
	glFramebufferTextureLayer(target, attachment, texture, level, layer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglColorMaski(JNIEnv *env, jclass clazz, jint buf, jboolean r, jboolean g, jboolean b, jboolean a, jlong function_pointer) {
	glColorMaskiPROC glColorMaski = (glColorMaskiPROC)((intptr_t)function_pointer);
	glColorMaski(buf, r, g, b, a);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglGetBooleani_1v(JNIEnv *env, jclass clazz, jint value, jint index, jlong data, jlong function_pointer) {
	GLboolean *data_address = (GLboolean *)(intptr_t)data;
	glGetBooleani_vPROC glGetBooleani_v = (glGetBooleani_vPROC)((intptr_t)function_pointer);
	glGetBooleani_v(value, index, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglGetIntegeri_1v(JNIEnv *env, jclass clazz, jint value, jint index, jlong data, jlong function_pointer) {
	GLint *data_address = (GLint *)(intptr_t)data;
	glGetIntegeri_vPROC glGetIntegeri_v = (glGetIntegeri_vPROC)((intptr_t)function_pointer);
	glGetIntegeri_v(value, index, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglEnablei(JNIEnv *env, jclass clazz, jint target, jint index, jlong function_pointer) {
	glEnableiPROC glEnablei = (glEnableiPROC)((intptr_t)function_pointer);
	glEnablei(target, index);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglDisablei(JNIEnv *env, jclass clazz, jint target, jint index, jlong function_pointer) {
	glDisableiPROC glDisablei = (glDisableiPROC)((intptr_t)function_pointer);
	glDisablei(target, index);
}

JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_GL30_nglIsEnabledi(JNIEnv *env, jclass clazz, jint target, jint index, jlong function_pointer) {
	glIsEnablediPROC glIsEnabledi = (glIsEnablediPROC)((intptr_t)function_pointer);
	GLboolean __result = glIsEnabledi(target, index);
	return __result;
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglBindBufferRange(JNIEnv *env, jclass clazz, jint target, jint index, jint buffer, jlong offset, jlong size, jlong function_pointer) {
	glBindBufferRangePROC glBindBufferRange = (glBindBufferRangePROC)((intptr_t)function_pointer);
	glBindBufferRange(target, index, buffer, offset, size);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglBindBufferBase(JNIEnv *env, jclass clazz, jint target, jint index, jint buffer, jlong function_pointer) {
	glBindBufferBasePROC glBindBufferBase = (glBindBufferBasePROC)((intptr_t)function_pointer);
	glBindBufferBase(target, index, buffer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglBeginTransformFeedback(JNIEnv *env, jclass clazz, jint primitiveMode, jlong function_pointer) {
	glBeginTransformFeedbackPROC glBeginTransformFeedback = (glBeginTransformFeedbackPROC)((intptr_t)function_pointer);
	glBeginTransformFeedback(primitiveMode);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglEndTransformFeedback(JNIEnv *env, jclass clazz, jlong function_pointer) {
	glEndTransformFeedbackPROC glEndTransformFeedback = (glEndTransformFeedbackPROC)((intptr_t)function_pointer);
	glEndTransformFeedback();
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglTransformFeedbackVaryings(JNIEnv *env, jclass clazz, jint program, jint count, jlong varyings, jint bufferMode, jlong function_pointer) {
	const GLchar *varyings_address = (const GLchar *)(intptr_t)varyings;
	int _str_i;
	GLchar *_str_address;
	GLchar **varyings_str = (GLchar **) malloc(count * sizeof(GLchar *));
	glTransformFeedbackVaryingsPROC glTransformFeedbackVaryings = (glTransformFeedbackVaryingsPROC)((intptr_t)function_pointer);
	_str_i = 0;
	_str_address = (GLchar *)varyings_address;
	while ( _str_i < count ) {
		varyings_str[_str_i++] = _str_address;
		_str_address += strlen(_str_address) + 1;
	}
	glTransformFeedbackVaryings(program, count, (const GLchar **)varyings_str, bufferMode);
	free(varyings_str);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglGetTransformFeedbackVarying(JNIEnv *env, jclass clazz, jint program, jint index, jint bufSize, jlong length, jlong size, jlong type, jlong name, jlong function_pointer) {
	GLsizei *length_address = (GLsizei *)(intptr_t)length;
	GLsizei *size_address = (GLsizei *)(intptr_t)size;
	GLenum *type_address = (GLenum *)(intptr_t)type;
	GLchar *name_address = (GLchar *)(intptr_t)name;
	glGetTransformFeedbackVaryingPROC glGetTransformFeedbackVarying = (glGetTransformFeedbackVaryingPROC)((intptr_t)function_pointer);
	glGetTransformFeedbackVarying(program, index, bufSize, length_address, size_address, type_address, name_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglBindVertexArray(JNIEnv *env, jclass clazz, jint array, jlong function_pointer) {
	glBindVertexArrayPROC glBindVertexArray = (glBindVertexArrayPROC)((intptr_t)function_pointer);
	glBindVertexArray(array);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglDeleteVertexArrays(JNIEnv *env, jclass clazz, jint n, jlong arrays, jlong function_pointer) {
	const GLuint *arrays_address = (const GLuint *)(intptr_t)arrays;
	glDeleteVertexArraysPROC glDeleteVertexArrays = (glDeleteVertexArraysPROC)((intptr_t)function_pointer);
	glDeleteVertexArrays(n, arrays_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL30_nglGenVertexArrays(JNIEnv *env, jclass clazz, jint n, jlong arrays, jlong function_pointer) {
	GLuint *arrays_address = (GLuint *)(intptr_t)arrays;
	glGenVertexArraysPROC glGenVertexArrays = (glGenVertexArraysPROC)((intptr_t)function_pointer);
	glGenVertexArrays(n, arrays_address);
}

JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_GL30_nglIsVertexArray(JNIEnv *env, jclass clazz, jint array, jlong function_pointer) {
	glIsVertexArrayPROC glIsVertexArray = (glIsVertexArrayPROC)((intptr_t)function_pointer);
	GLboolean __result = glIsVertexArray(array);
	return __result;
}

