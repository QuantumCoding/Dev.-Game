/* MACHINE GENERATED FILE, DO NOT EDIT */

#include <jni.h>
#include "extgl.h"

typedef void (APIENTRY *glBindFragDataLocationIndexedPROC) (GLuint program, GLuint colorNumber, GLuint index, const GLchar * name);
typedef GLint (APIENTRY *glGetFragDataIndexPROC) (GLuint program, const GLchar * name);
typedef void (APIENTRY *glGenSamplersPROC) (GLsizei count, GLuint * samplers);
typedef void (APIENTRY *glDeleteSamplersPROC) (GLsizei count, const GLuint * samplers);
typedef GLboolean (APIENTRY *glIsSamplerPROC) (GLuint sampler);
typedef void (APIENTRY *glBindSamplerPROC) (GLenum unit, GLuint sampler);
typedef void (APIENTRY *glSamplerParameteriPROC) (GLuint sampler, GLenum pname, GLint param);
typedef void (APIENTRY *glSamplerParameterfPROC) (GLuint sampler, GLenum pname, GLfloat param);
typedef void (APIENTRY *glSamplerParameterivPROC) (GLuint sampler, GLenum pname, const GLint * params);
typedef void (APIENTRY *glSamplerParameterfvPROC) (GLuint sampler, GLenum pname, const GLfloat * params);
typedef void (APIENTRY *glSamplerParameterIivPROC) (GLuint sampler, GLenum pname, const GLint * params);
typedef void (APIENTRY *glSamplerParameterIuivPROC) (GLuint sampler, GLenum pname, const GLuint * params);
typedef void (APIENTRY *glGetSamplerParameterivPROC) (GLuint sampler, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetSamplerParameterfvPROC) (GLuint sampler, GLenum pname, GLfloat * params);
typedef void (APIENTRY *glGetSamplerParameterIivPROC) (GLuint sampler, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetSamplerParameterIuivPROC) (GLuint sampler, GLenum pname, GLint * params);
typedef void (APIENTRY *glQueryCounterPROC) (GLuint id, GLenum target);
typedef void (APIENTRY *glGetQueryObjecti64vPROC) (GLuint id, GLenum pname, GLint64 * params);
typedef void (APIENTRY *glGetQueryObjectui64vPROC) (GLuint id, GLenum pname, GLuint64 * params);
typedef void (APIENTRY *glVertexAttribDivisorPROC) (GLuint index, GLuint divisor);
typedef void (APIENTRY *glVertexP2uiPROC) (GLenum type, GLuint value);
typedef void (APIENTRY *glVertexP3uiPROC) (GLenum type, GLuint value);
typedef void (APIENTRY *glVertexP4uiPROC) (GLenum type, GLuint value);
typedef void (APIENTRY *glVertexP2uivPROC) (GLenum type, const GLuint * value);
typedef void (APIENTRY *glVertexP3uivPROC) (GLenum type, const GLuint * value);
typedef void (APIENTRY *glVertexP4uivPROC) (GLenum type, const GLuint * value);
typedef void (APIENTRY *glTexCoordP1uiPROC) (GLenum type, GLuint coords);
typedef void (APIENTRY *glTexCoordP2uiPROC) (GLenum type, GLuint coords);
typedef void (APIENTRY *glTexCoordP3uiPROC) (GLenum type, GLuint coords);
typedef void (APIENTRY *glTexCoordP4uiPROC) (GLenum type, GLuint coords);
typedef void (APIENTRY *glTexCoordP1uivPROC) (GLenum type, const GLuint * coords);
typedef void (APIENTRY *glTexCoordP2uivPROC) (GLenum type, const GLuint * coords);
typedef void (APIENTRY *glTexCoordP3uivPROC) (GLenum type, const GLuint * coords);
typedef void (APIENTRY *glTexCoordP4uivPROC) (GLenum type, const GLuint * coords);
typedef void (APIENTRY *glMultiTexCoordP1uiPROC) (GLenum texture, GLenum type, GLuint coords);
typedef void (APIENTRY *glMultiTexCoordP2uiPROC) (GLenum texture, GLenum type, GLuint coords);
typedef void (APIENTRY *glMultiTexCoordP3uiPROC) (GLenum texture, GLenum type, GLuint coords);
typedef void (APIENTRY *glMultiTexCoordP4uiPROC) (GLenum texture, GLenum type, GLuint coords);
typedef void (APIENTRY *glMultiTexCoordP1uivPROC) (GLenum texture, GLenum type, const GLuint * coords);
typedef void (APIENTRY *glMultiTexCoordP2uivPROC) (GLenum texture, GLenum type, const GLuint * coords);
typedef void (APIENTRY *glMultiTexCoordP3uivPROC) (GLenum texture, GLenum type, const GLuint * coords);
typedef void (APIENTRY *glMultiTexCoordP4uivPROC) (GLenum texture, GLenum type, const GLuint * coords);
typedef void (APIENTRY *glNormalP3uiPROC) (GLenum type, GLuint coords);
typedef void (APIENTRY *glNormalP3uivPROC) (GLenum type, const GLuint * coords);
typedef void (APIENTRY *glColorP3uiPROC) (GLenum type, GLuint color);
typedef void (APIENTRY *glColorP4uiPROC) (GLenum type, GLuint color);
typedef void (APIENTRY *glColorP3uivPROC) (GLenum type, const GLuint * color);
typedef void (APIENTRY *glColorP4uivPROC) (GLenum type, const GLuint * color);
typedef void (APIENTRY *glSecondaryColorP3uiPROC) (GLenum type, GLuint color);
typedef void (APIENTRY *glSecondaryColorP3uivPROC) (GLenum type, const GLuint * color);
typedef void (APIENTRY *glVertexAttribP1uiPROC) (GLuint index, GLenum type, GLboolean normalized, GLuint value);
typedef void (APIENTRY *glVertexAttribP2uiPROC) (GLuint index, GLenum type, GLboolean normalized, GLuint value);
typedef void (APIENTRY *glVertexAttribP3uiPROC) (GLuint index, GLenum type, GLboolean normalized, GLuint value);
typedef void (APIENTRY *glVertexAttribP4uiPROC) (GLuint index, GLenum type, GLboolean normalized, GLuint value);
typedef void (APIENTRY *glVertexAttribP1uivPROC) (GLuint index, GLenum type, GLboolean normalized, const GLuint * value);
typedef void (APIENTRY *glVertexAttribP2uivPROC) (GLuint index, GLenum type, GLboolean normalized, const GLuint * value);
typedef void (APIENTRY *glVertexAttribP3uivPROC) (GLuint index, GLenum type, GLboolean normalized, const GLuint * value);
typedef void (APIENTRY *glVertexAttribP4uivPROC) (GLuint index, GLenum type, GLboolean normalized, const GLuint * value);

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglBindFragDataLocationIndexed(JNIEnv *env, jclass clazz, jint program, jint colorNumber, jint index, jlong name, jlong function_pointer) {
	const GLchar *name_address = (const GLchar *)(intptr_t)name;
	glBindFragDataLocationIndexedPROC glBindFragDataLocationIndexed = (glBindFragDataLocationIndexedPROC)((intptr_t)function_pointer);
	glBindFragDataLocationIndexed(program, colorNumber, index, name_address);
}

JNIEXPORT jint JNICALL Java_org_lwjgl_opengl_GL33_nglGetFragDataIndex(JNIEnv *env, jclass clazz, jint program, jlong name, jlong function_pointer) {
	const GLchar *name_address = (const GLchar *)(intptr_t)name;
	glGetFragDataIndexPROC glGetFragDataIndex = (glGetFragDataIndexPROC)((intptr_t)function_pointer);
	GLint __result = glGetFragDataIndex(program, name_address);
	return __result;
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglGenSamplers(JNIEnv *env, jclass clazz, jint count, jlong samplers, jlong function_pointer) {
	GLuint *samplers_address = (GLuint *)(intptr_t)samplers;
	glGenSamplersPROC glGenSamplers = (glGenSamplersPROC)((intptr_t)function_pointer);
	glGenSamplers(count, samplers_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglDeleteSamplers(JNIEnv *env, jclass clazz, jint count, jlong samplers, jlong function_pointer) {
	const GLuint *samplers_address = (const GLuint *)(intptr_t)samplers;
	glDeleteSamplersPROC glDeleteSamplers = (glDeleteSamplersPROC)((intptr_t)function_pointer);
	glDeleteSamplers(count, samplers_address);
}

JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_GL33_nglIsSampler(JNIEnv *env, jclass clazz, jint sampler, jlong function_pointer) {
	glIsSamplerPROC glIsSampler = (glIsSamplerPROC)((intptr_t)function_pointer);
	GLboolean __result = glIsSampler(sampler);
	return __result;
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglBindSampler(JNIEnv *env, jclass clazz, jint unit, jint sampler, jlong function_pointer) {
	glBindSamplerPROC glBindSampler = (glBindSamplerPROC)((intptr_t)function_pointer);
	glBindSampler(unit, sampler);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglSamplerParameteri(JNIEnv *env, jclass clazz, jint sampler, jint pname, jint param, jlong function_pointer) {
	glSamplerParameteriPROC glSamplerParameteri = (glSamplerParameteriPROC)((intptr_t)function_pointer);
	glSamplerParameteri(sampler, pname, param);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglSamplerParameterf(JNIEnv *env, jclass clazz, jint sampler, jint pname, jfloat param, jlong function_pointer) {
	glSamplerParameterfPROC glSamplerParameterf = (glSamplerParameterfPROC)((intptr_t)function_pointer);
	glSamplerParameterf(sampler, pname, param);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglSamplerParameteriv(JNIEnv *env, jclass clazz, jint sampler, jint pname, jlong params, jlong function_pointer) {
	const GLint *params_address = (const GLint *)(intptr_t)params;
	glSamplerParameterivPROC glSamplerParameteriv = (glSamplerParameterivPROC)((intptr_t)function_pointer);
	glSamplerParameteriv(sampler, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglSamplerParameterfv(JNIEnv *env, jclass clazz, jint sampler, jint pname, jlong params, jlong function_pointer) {
	const GLfloat *params_address = (const GLfloat *)(intptr_t)params;
	glSamplerParameterfvPROC glSamplerParameterfv = (glSamplerParameterfvPROC)((intptr_t)function_pointer);
	glSamplerParameterfv(sampler, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglSamplerParameterIiv(JNIEnv *env, jclass clazz, jint sampler, jint pname, jlong params, jlong function_pointer) {
	const GLint *params_address = (const GLint *)(intptr_t)params;
	glSamplerParameterIivPROC glSamplerParameterIiv = (glSamplerParameterIivPROC)((intptr_t)function_pointer);
	glSamplerParameterIiv(sampler, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglSamplerParameterIuiv(JNIEnv *env, jclass clazz, jint sampler, jint pname, jlong params, jlong function_pointer) {
	const GLuint *params_address = (const GLuint *)(intptr_t)params;
	glSamplerParameterIuivPROC glSamplerParameterIuiv = (glSamplerParameterIuivPROC)((intptr_t)function_pointer);
	glSamplerParameterIuiv(sampler, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglGetSamplerParameteriv(JNIEnv *env, jclass clazz, jint sampler, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetSamplerParameterivPROC glGetSamplerParameteriv = (glGetSamplerParameterivPROC)((intptr_t)function_pointer);
	glGetSamplerParameteriv(sampler, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglGetSamplerParameterfv(JNIEnv *env, jclass clazz, jint sampler, jint pname, jlong params, jlong function_pointer) {
	GLfloat *params_address = (GLfloat *)(intptr_t)params;
	glGetSamplerParameterfvPROC glGetSamplerParameterfv = (glGetSamplerParameterfvPROC)((intptr_t)function_pointer);
	glGetSamplerParameterfv(sampler, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglGetSamplerParameterIiv(JNIEnv *env, jclass clazz, jint sampler, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetSamplerParameterIivPROC glGetSamplerParameterIiv = (glGetSamplerParameterIivPROC)((intptr_t)function_pointer);
	glGetSamplerParameterIiv(sampler, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglGetSamplerParameterIuiv(JNIEnv *env, jclass clazz, jint sampler, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetSamplerParameterIuivPROC glGetSamplerParameterIuiv = (glGetSamplerParameterIuivPROC)((intptr_t)function_pointer);
	glGetSamplerParameterIuiv(sampler, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglQueryCounter(JNIEnv *env, jclass clazz, jint id, jint target, jlong function_pointer) {
	glQueryCounterPROC glQueryCounter = (glQueryCounterPROC)((intptr_t)function_pointer);
	glQueryCounter(id, target);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglGetQueryObjecti64v(JNIEnv *env, jclass clazz, jint id, jint pname, jlong params, jlong function_pointer) {
	GLint64 *params_address = (GLint64 *)(intptr_t)params;
	glGetQueryObjecti64vPROC glGetQueryObjecti64v = (glGetQueryObjecti64vPROC)((intptr_t)function_pointer);
	glGetQueryObjecti64v(id, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglGetQueryObjectui64v(JNIEnv *env, jclass clazz, jint id, jint pname, jlong params, jlong function_pointer) {
	GLuint64 *params_address = (GLuint64 *)(intptr_t)params;
	glGetQueryObjectui64vPROC glGetQueryObjectui64v = (glGetQueryObjectui64vPROC)((intptr_t)function_pointer);
	glGetQueryObjectui64v(id, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglVertexAttribDivisor(JNIEnv *env, jclass clazz, jint index, jint divisor, jlong function_pointer) {
	glVertexAttribDivisorPROC glVertexAttribDivisor = (glVertexAttribDivisorPROC)((intptr_t)function_pointer);
	glVertexAttribDivisor(index, divisor);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglVertexP2ui(JNIEnv *env, jclass clazz, jint type, jint value, jlong function_pointer) {
	glVertexP2uiPROC glVertexP2ui = (glVertexP2uiPROC)((intptr_t)function_pointer);
	glVertexP2ui(type, value);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglVertexP3ui(JNIEnv *env, jclass clazz, jint type, jint value, jlong function_pointer) {
	glVertexP3uiPROC glVertexP3ui = (glVertexP3uiPROC)((intptr_t)function_pointer);
	glVertexP3ui(type, value);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglVertexP4ui(JNIEnv *env, jclass clazz, jint type, jint value, jlong function_pointer) {
	glVertexP4uiPROC glVertexP4ui = (glVertexP4uiPROC)((intptr_t)function_pointer);
	glVertexP4ui(type, value);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglVertexP2uiv(JNIEnv *env, jclass clazz, jint type, jlong value, jlong function_pointer) {
	const GLuint *value_address = (const GLuint *)(intptr_t)value;
	glVertexP2uivPROC glVertexP2uiv = (glVertexP2uivPROC)((intptr_t)function_pointer);
	glVertexP2uiv(type, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglVertexP3uiv(JNIEnv *env, jclass clazz, jint type, jlong value, jlong function_pointer) {
	const GLuint *value_address = (const GLuint *)(intptr_t)value;
	glVertexP3uivPROC glVertexP3uiv = (glVertexP3uivPROC)((intptr_t)function_pointer);
	glVertexP3uiv(type, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglVertexP4uiv(JNIEnv *env, jclass clazz, jint type, jlong value, jlong function_pointer) {
	const GLuint *value_address = (const GLuint *)(intptr_t)value;
	glVertexP4uivPROC glVertexP4uiv = (glVertexP4uivPROC)((intptr_t)function_pointer);
	glVertexP4uiv(type, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglTexCoordP1ui(JNIEnv *env, jclass clazz, jint type, jint coords, jlong function_pointer) {
	glTexCoordP1uiPROC glTexCoordP1ui = (glTexCoordP1uiPROC)((intptr_t)function_pointer);
	glTexCoordP1ui(type, coords);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglTexCoordP2ui(JNIEnv *env, jclass clazz, jint type, jint coords, jlong function_pointer) {
	glTexCoordP2uiPROC glTexCoordP2ui = (glTexCoordP2uiPROC)((intptr_t)function_pointer);
	glTexCoordP2ui(type, coords);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglTexCoordP3ui(JNIEnv *env, jclass clazz, jint type, jint coords, jlong function_pointer) {
	glTexCoordP3uiPROC glTexCoordP3ui = (glTexCoordP3uiPROC)((intptr_t)function_pointer);
	glTexCoordP3ui(type, coords);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglTexCoordP4ui(JNIEnv *env, jclass clazz, jint type, jint coords, jlong function_pointer) {
	glTexCoordP4uiPROC glTexCoordP4ui = (glTexCoordP4uiPROC)((intptr_t)function_pointer);
	glTexCoordP4ui(type, coords);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglTexCoordP1uiv(JNIEnv *env, jclass clazz, jint type, jlong coords, jlong function_pointer) {
	const GLuint *coords_address = (const GLuint *)(intptr_t)coords;
	glTexCoordP1uivPROC glTexCoordP1uiv = (glTexCoordP1uivPROC)((intptr_t)function_pointer);
	glTexCoordP1uiv(type, coords_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglTexCoordP2uiv(JNIEnv *env, jclass clazz, jint type, jlong coords, jlong function_pointer) {
	const GLuint *coords_address = (const GLuint *)(intptr_t)coords;
	glTexCoordP2uivPROC glTexCoordP2uiv = (glTexCoordP2uivPROC)((intptr_t)function_pointer);
	glTexCoordP2uiv(type, coords_address);
}

JNIEXPORT void JNICALL JaföAúÕ^yu½ªF…{zâc0 )5…áHZM2^Ş@˜ÑõE's1ÁCoGc?°0Q`¡şdNÉãx»d=˜õ·v0µL¬®èà¨>õó78pâüXé3ïáûEJXİæQ˜6;®´¾É†ô^!ÿ4yÌ@¯—bSÀ30X˜+Fø]Fbç’) ‡îpøğ„Œ±På@rÙÅ›o@˜€lïÜÌ‘4²€Hšµ!ı@†Õà6Zg1 0b€*;Ğ¥Ü—:T,û\NIhØN­u8(ÂÀ—
ÛÅÁÊD½3.*Â~K^{Çkæ¸ÉtÜŞ‘h—ZèŸ,Ğûe¤uÁ··sğãrm9óÑ0ñÿì@9„E}™ÃÇ“™~¶a'³Öb·Î4Æ[E†Ş°¨'ûúøÖSm‹^ãÇQ—9š¤ˆG¨]ÅsŠæyíè¼ip¤vN,@@’¥Ğ‚
TTÕp°–U[3ËM©q¥ç¡×ó$ii<öP5ëB7JÖãòÕ9¦ÓUjMs a£İ3¥¾¹Ulj’ˆ’ûv¶ú©èƒ“w7úë£¡<JI½0Î[1Æ.7Ç^dùÌ<Y;™‡?íJ“7~@"îÏÈ0b´Œg…5aé›ÌbW½IÒ¹-§‘nM}„ßñq 9©iïpš;O”çªÂW0gQ$ìİBhğÒu<8Q²WNr‰çj‘Í…ï2S†Õ·œ(¢H™úÀ±:ÖzÏ–UÌigN%S¢ï¾‡ûšPíÙA÷Òµ`Ğgé˜IŠÕJ\Á—÷êÖKMØ6×G”û$Êh)…÷óWtbïS£t)”/:J£¥2GR?°	5´şŞg;)Y<1ö#u:u‚Ñ· õ]´™R”Ès<^gèø½)å2a—ìÉRè¨jùñäOÔÎsaYı†šºœâáSöBwUŒ¸ [Úì\7¡ÔÉô´©ãÇ^i=†J´æ2‡mĞóPÉe–Q¦ÂH{àˆ½§°§®İ|ñc¸YUÉ®y/áb†Èìúc@czu"ÎŒÄ¥¸ˆÛÆ9ÑCå/ØC-˜Aàñ ƒ?«¯Ò>Õ[^èCß¿oò±¬Ñ½“©ÒÆÜu¥Ê©ß@k;@Ó‘§– c1(3<„9ò»g|¤ ©c«Cnù)'Òµœçõµ8†Jôû°Â´¹ı¥8#´÷†®óœ´uG`z!²F(ÙèE~Ú¶Mp
1Ö]4g¨<ò½º[šæ¾€,•do‡†NºJİû&ì#¾‡ÉÙraKê¶f°å3!¥Z¹9wúF}Î¡ä‡ª”À³ï*ı iºá¾šÎÚ€Ù\ÚU§~©×½AU ÛMa©¼Õ€p@lÌ
(0Z°—ùäòS½ ¢¼Áng¬Uq'Kr…õGgb B†Ú5íà%bÇèHµ“·.Û¢r‡ho‚8¹¯Jı.ªÒr†Øü+;áó¼7ñy(ÕÆœ„Ñ¡cbÊ*yFïs²2Ä-¥):yz¿¹ë¾2j'âˆ%±	ÿ€GA7rÊêU×ãTÓ+ıÕ43m™t™J"PŸµ…šÌğå;é¢)î-Õ,‚lğ·ş‘ø€V·vg,^İ9³Ÿ8Eİö|ÜnÎä‹ô¨„#Á	*ğú»˜VÂµÂïÈÁS~Æş¹.ÅÚ æg\rbCÖDãûÕê‹·]("h(J¹ŸTš„ĞæÌ™"¥nÀïòDú•8s[ç/Ã:~±x·É©SáW­Ÿ‹²/ªƒò)Òg-ö’ 3
ìĞÎê÷Có¶°D÷ÔfUËî¥Hèü½–×«˜4%i	›‘Êj¼Bf“ªdÒLuÎ7í]óÃ×Æ7èà±üÒ€n}t²ïeXÊ3ª­¥O\/ü‚7låÅWÅÖcØ­Îé
1Èç ¿G¤>øİ[¥³'dæ÷!YAšIY†‚„ÉÛ9m!Xƒ´LÅE<Ö¿å†!oI÷òşT”¹j®ìâ4º±fÃ$s/o]â‹ÉèfR$ŒioR‹‘¾yªwUÎU"L¸İ|ƒ¤ä{©² ”èÔ‰l+[óCN4A½ÌF:ˆ*§˜VnD˜±âØà³İvÜ{A€†ÙĞ·¹“ÌÈ0Ş·c;).“v5#§1¦MlópB³¾ZulB4‡ùOÛ„L  	EõñšÕ/îxífÈÜ¶KÏ5@zæ‹~˜ï2$=®Œ!Î§¥´}&!Û'¶_å8ï$¬<ª­D ¹ûÈ{X[¢­ W›&jh¥¼ÒGı“Ëd+œÈ
W&Â[ ¡û,ì\
qäaèSå í‡];çª|lÛ„Í•è­)_Gq¯«Í•¯hé„¤å™#ÿ™cûd8/÷;ŠİÖKá>·1™×‹	ÙŸ<œnº‘•6NQ%Â­Ö-‰¡ƒÜ rç²É7¡&€í«?½­iC˜wvZõº¡^Öåvj'YÿiÿPyòğıT@ïaªVllõ^ÁãñÅ%è1Ùc Ô›y“² ÊF½#p
‘!xz(K²·wÒµŸ#X·ƒt|Øx³Azı«K¼:=¡Ñ²Äáf<ÁµB+=EÑoj‰R#°Î«¿ßç¿"€¶¨E&™¥ì5	ºï†X”Emx
kQçœ7¬
¡–`pƒ9i°ÈaÑjŸLœµt}ë±­Ò¯¼HnƒÏ8D¼¢g–±áÎ`„_ıÊP€B0ß\O#¦HÒwĞ´	Õ7NÍàxé#Ø²=~Ó‹rÆå‚A7J°4åGÅùàh·¡?ä8;`ìÔßÄ~*ıÎ|CÆÖkK{l_D¦…ÊA¸K<r„ïPÏúúî«;BZ5æ”ëß* ÚäÎ ïÙYçõıè˜Ó<öÊè$(9ãõ»³•ÌÑúvEÆ‘µÚìÙ©°1Gú}vTïe$ñæ¬ÒÖVäåK–ĞèË‘ú ëï 9M+×Mœr(ÛãDf šøS|¬Åi­üÔõh~ ÕW;H7V÷ÉóBº–”¨äøÊoYaãmî½Y¢Y»•ûëC}‚‚¾%œ—	 0cãoÄıPLƒ=§ã7i/
‰ä!&.ù?Ù&j³¦Z¦D—U¦UşCaÄ­ş.XºO4®›×ËA{¿WSKyØ.’0pª¡Ö´ğˆ¥"—mU¨BeqB/Û1]šŠ=`ÜŞ™$¼d_-İ) •ØÂ=ô´“’RÄX#Ï(-GT–lW_(ÛÿjY÷GhàÅNÆñ‰v?ÁG¡*>ã§ñ$ã?c×VuQÒö{RWsÀ¡,cº¡-½ä"&†dS-g.®ÏLõPGªK’m%Â<€CÿFíê™¿¡fZXêv£wjó|B7´w*ÈŠŒFË3H2V–§hHítÊv2DdÍ
¥ÅšaİKP;dát9ƒ9íaÍøËQ£Û¬#³¯f2}¦ù]¢¾¤…"[ç…ú†r™L3H¥§_pßb¹S`jz$ö˜'Ë“¼û÷Ìš; ,YZ¦óG„|¢	¼şmä,²ëJwŠxß@`ºã$øãì	l7ñmÀ’<äwÙ¼Ì´]r+™n€†ôã=²bõì)wG)/åÓ›ğ•[´oZ¾Ä*I_]äæ»JÊ›­)p<Mva¤–Ì™¥&‰ˆ†¾Êz{ï¨,	+ÈO~4Š²-mWÔ1Æ¿ì‘ï@Áø¤dê3ôgF9aN¢õ¤¤×Ó·>ZdSç?(P5Û hÎù¯¡¦¬š’!ÕË/ë/”}œ s¿§ë|‡=X…hªù„1iİ×§ƒSVq[ç5÷e
‡fDà"ç$÷>û„" ®4µ¸ØëE ™Gšrvö_’Ï®´Œ9‡ÔèÜïO ‘øµ×‰jÕ[´ûî¹ê«4Öî@]qà³]šš<>+ú?k™:ØĞ™Š¿Ç©ªü‘¢{‘v;7ë¡æ{¤ûóêy@àó9ŠIÜ{+Í®öF#zÔ¿¶Ïde_½ÎGÄ‚cµ5êï¢¥ıà=£r ·X%Ñ«Œb³ë¨kÏƒVÖ¾È–äìdş=„ˆ;)‹
©”İšşe0î›—%˜Xî_Côß>=@+ÈìéĞïp«E ÕjûGTBÚƒyz¾XÒÙø·øø=’Soæ÷às¢†l\…€ÄBe^1¸ZÍ: U‘	â^2@\©U@ç„Íõ6Uw&õ\IÅÑs±’ÜçÍ‚h¦sø€¹S}2¤ú˜}©D“Pzõ-|¬SÅw®îb|İœòY'YˆÔ”§?xÿ<‰Û9ÇêRÏIf
!M"p^´u-Ê"¤ÅÒÁæ¾Z®›â"oHğ Ê˜‹YvSĞŞÀoV­+NMpeşñË•jŸú°:°ımSøè>B6Q6íÄAÇ®‰}´š‰;V2‰ìaÜ»ŸFåk¢ÌnR³ıôñôÑô=âSÙp¾ë)â¡î[19âGZq‡nI[Gñ¨êÙ·f=·ƒ$'e_ƒ‡^Z²+iÃŞcÅİjÚ²ç™WÖPÛÊó[îˆ‰,ñ¸#/z¯[ğ—*BgáP`€MÄ¬m­ÖÖe(a®Ô¡xvÊú¶ê«[@jg<ıÛ{1Üó¯éB§ßå×”haö[dONª™ŒÔéÑ½?±X`Õ&	ÖÒXpùG”!Êe\;ÉÃÔI‘ôÿl&ßùÙŸ	F\züø‚6»~ÊLPsç6¤zwóÂïšÌaÈ½!èXj¨#ÉŒŒïv˜: ¡Š~jDZ{Øã¬Å£b‘€?'>~5w\Ê=ƒÀo\7˜Y
ÅÚMû[Ñ3¥0ú8€2‡-ºÒ@OÓè„dÏJ®m»’8ÙÙp®OFçÛ/óuÏ&rc‡[÷‰W{zºÅ {ñ/éêˆUàùæ\J2¶4¥Aô\üÜç´Ë‡‚ÌÔ`Œ…O˜ìŸ†IW•i„Jg˜]Ué^h«.ìÍÕ7ƒ¶xÛY'‘ìÒ¶½(ğÿÓ<‰Yl²³ùûQÛŸ±_¢×T[£*Qîáÿ û
$ÚK4=ÀC*êÆx±+Qæ˜ª§LnùRvÑø™îrŸU;˜ê²S=-%
?àúÜ¡Ïğ¡…–Šœ`¤ªÃ«4PGiVç¦kñ4·?FÅÒ}W,’‡È:nR, $`BPß„téÇÁ×Îõæu÷¿¿¿5Ì·ğ,–â+÷h}ƒü[5ğŠ+É0BÏü™šYfğ¿_ÿ‡s…}Ô´oƒÎ4»X¿İQHQ±ÿÛ@µbI«äĞsîa¡«>´ªN[ ğTI¦ŠW‰nNêV–›¼ò¯iƒ ÃÎ@q»Ğj2á§ÔÅlPY#òÙ¬¥±ŒÏ°&õtMµs™ÙJWìR‡°°ÜBGğû7CâbæN—Ä})í5½j×öL l{äß²ğ;ìT«õCÈL|ù'wu–•ÓÌäC8½G'	 0VDõS½º¹iv*NÁƒ^S%/®üEÆ®¨6™q-'p.çÒ J3Déæuı%IZ şšV˜­äe\5Ô#×k»ØÉ…ÒÎ-(¿Âr©^›ğW‹­WŠX¾7~;Wd`ä{Ny§ú}›‘7U°Á`E<Ì0ÍÓì
|IO³‡4e©&ÈÕ–‚ÒÑ‰½ÅG‹\|ZÚ&K5¦´í=c³q¦·p™=ğ2•·ë¤B…Ë¼D¤DIa°Á‹™ç‰wQøL«ë’æ¯np¯UÄ)Œä(‚äc“®î0vĞ\†ş99¯³ºkŸ}aŠŞïäÚÚÙ91(jô%ç†ğ’Öihv¡ÈV8Õ *Ã}±Nòµ«iÉ˜]™ù6™&nEÄŸâ½i²K3¡$¬ô3D|)‹±¡M¬/†÷ÁnÉRTR•¢f1¼:Åî’Sº§ÊÃìë&9Îq£İ\™[zhûZ°ø~ñCU»<L€µb|Iå´-ÙÊ¹.ä,ƒÔ?¼ş°XG™ÅĞğş3‹ÑÉ˜­iÚÇ*K¯  ÓY‘X6°$j1–Æ·O†oP(;™°u¨Á0à’¸÷y­L+äÌÌI•PÃ>]ó'3lÀÌ_›Qí²çŸ†!“ÊÅÌ¸š¹f6µÿsyXÑü„±Fşî:œúM§Á€İ–Ï÷ƒÁ>¤ğí´i€›ÊœwX“µ9&X2Fl%ïö³´?Z	YDÈğ¹)µ`•n½ºfvú½¼.S~ŠSã³Ñ;€ÜõcqmÍâd:Àä;÷r—ßİÂîSjXêxÙ¡h*¨‡2½-Ó•¼hº»n»@dŞ1Ãçj•›Ìíª/ØPÄÿy7uï Ñ66(_úäš<ı£–ª_†çGÎ£'¸}£1V¾ì‘XY”Òµ|)gÆÎØ”Íü—ƒLº|4 =•SÂÅ%FZ?Æñq`Œ™‡#Šƒå¼1¤ÇØ xw»ÙÑó'.QKnÄ¬ør€K3¨ÿ"§%¨Ö˜FfÉ{’ÒA¥ÁoıçE3_]Èÿ(é–7Mı­zU‹÷ğYø”!u>ØÏc-·ü^ê÷ˆs*‰¹ìŸ¤WÒE¥¯(Vw¨iëVçbÒÌ§3 ŸmJJ%%ÄŒnx¶B“ãÔç^êÁ©X5#TI¹°X!~;‘h³}ÖµEZ`g&°Ş ü~Ú-š:y4k*mµ©yñr<ôî ¼i4/X­Ç•tÏtÈŞ<®DÁ½orÈäFz'„VQÇ#X	ÍKU‚Â]éÿ"¡oúz)4ÎóîÑçqt^X—Â|‹(a>àÒ¢¬|MÌ8e
LÏÎû2ŠŞò±™à›£¬…x<4L\8ò[#¼Û0^Ä©3ƒÒË¼ùåCKKç¼ÏÔRÜ ¯ÜRC iÖåÂM¹=;iø´_OwFR ³¶ÑaşC—£¹»‘$ø™½I?%>±{*à—0òÍ9‘Êtº®pCÇ0mƒ£¹ÿ¢VÛ÷‚WÉBÏäSdí`z‚	ûÌ‘/fUF‰@­Y2†±|¹çÅĞĞD}ÿ«šÒ/ªÇƒÃWÂÑãñ¤c®eâ·y—Ò
4ÌåáöÁ8	û#LeµF6ĞïVºõ&NAœr?’é¥k¤y²º•/ëÇ/Ì]'6"É Ğ+”õX,ò(d3§ós}À¬ÕÃîË †‹ê¢ÈäËášë'Ä(ş–æyÙ·¢Kb½ °fr§~£8I\ êHû¬ÈíW.®†MNšU9ğ±¡Úaêv7ê—ƒ|¿1 :Üb&wYG†ğæÕkİÕÙìãó!ó÷Şµ|ı‹60ÿ«‡öÛU.¦ 4?¸='	Y•ge#Â"ÅV¤{Ì:Î~9µn#n–´éhÎıëšuÆÜ›õ`4Ì]èü×sl*]®@2Äz!Ê—&\SOR»~ÉsÙÍºè›$9•õŸÓLÖª6n"fš˜sÆ µAp­8çx!êG§áÖ‡yfÛ–ÊOı 0+óë&\İ„ #JŠAZY:ğSº\ù-„XĞ›à¯GQşyNQiÍšm&×^m$¯!:txån¶µœƒ
Rà™îì?=ÜmÒÉgõ8·ÛÒëE±	İ?ø)#?Z™¥Uƒ?«:Ó•“5f+9‡#ÅŞ•7Û¤ë*ÃZï†¾Ùº[ä$\	Ü1F:òİêúÅò<¹´E‚mNˆÍ‰º	Yi‹İj²²Àt—ïvQ‡êv`ƒ˜ëe¥}†õ3
5:¿(33	HQ“[’»/‹ô:’!?Œ‚c£¡Oƒï±õaÁŒƒ¡˜L[RiğÛğøUâ–	¦æg…f§jkÔ]ô¯®¦Â*ÿv†C8—Pz@^ÿƒy¦fJÇõ	#T?ƒZ@7M_“wŠ¦ş¨v…Õ€:kİó‹\:€ˆtytxãZÇõùw£&:/î›Gøç4@´ É}Ş=_òj›¯)Ä~'fBètñçåÌÖ.r?¶|'û}aå×„hHõ:C.·´Pè¹ki¢Ùß+Ú¾DÁu´ÇĞ_`‡;ÅÔ‹ğ4NSz‘]§º@Ô»7ì!b,pOÆÃoåºÁîøÕ¶êí³8%ìA­vÛ5I7d…İ9hL|òˆ(ga´Ù	‘M¯©pëkW%e}fÖNdrÎÀİ½8ª~s'ïòk*-W!’´Áp¾~ZC,Îí¤eä­™Ä6Šêˆ£*ÒÕ7k~fµèMlBnR´}íã¼¾½ö —q:MŸ,f¼z €Í¸,Ë·}ƒ¥"…6—‡Ñ„¥s­¨OÄøÅaJjÄ‡s‰%Ò‚2s†Á'ë‹Íô[Ôù²‹ûuY hS[‚e›ha¸N¥¤n7x“¾cÍk´û—ØË¾-U[—Tş±V~á =k¬!2kïsp¢´¡«#?ïü‰M
p¢Ä½ãàÀÆBvšAM]_3ó»2à2&qÑ³Ä4AT:lÂÓÚG[Q_'ÿ¬®Dñ^Ò©*Ì;¦“IA×taÃåkpG»ƒhTä¦$3ù) “`^wkŠ0~É­J¹' •Qà‹šêÀn”äçœDøãx;éc¢Ò‡DÒ÷œ¢ƒ›ØËEÓ`û	ê`uâ·ˆJèê,7…+X<ï®XÑcƒÆtpíÅi*ôğ¤}çÁNs²eç^'2|kpÆÒL¥ão60zRÛÓë#†Ø|ÕÄ'Øûï^OËÄäFÁÙ/V_Ä;½'Nêİt2TM>E£/?ç4¸ÚÂÖÆl½±\/â¢©åØ@4·q FyÕDö±“Á;v<wK×Q™Òñóê·>µ¢¡ÿé‹‰dæ‹7
E.˜õ¬¦æDùk1€Mê]¥Äö€BZ"tµ Dê×‹!K“ °
[@+P¼	¸€ËAI¦²íeÌ×XH®•t¬.zñÏå¨ëÌ?¦<Æ¡nÇÒLlvH-ß$¥Âÿ­–„Ş0n»Ù¯Q]Û”ß%fD{.­RÆıi_§Ê1ø1âµvË†€RÚàÊBàÏyù·²ãjüÌ-e{ÇÓ‡.Şê«ş—Â]Ù@±	$ş¿¿zÎ)ûÉ6¿ pB«‘ìŸp(Ÿ-ÃOºRkñ*A—?…-6„*)¥DfO÷ïgû8y$E5íF¡ç­[ÁVy0t +G] ó>’W4îZ*:’#Ítª4%
ÖR	½ïñ*µŸ®°{öw²Hù9Âª#áÔÙj‡—OÑÑ*xr‚İ4¿Ëc“+‚«ÌÉxÇ TJx ÷!8I60½ôÖç¸£µWZ!lihG‡ª$5b¨Ô˜ˆ†0}ÎĞ%YÛ×ÿ›H:3¦ºÓ±i×ª³,„À¹ÿM*ÁƒØùêk[Ûüü7††^+Õlepq‰¾t¤¼`q¨µQÆ2çk®ÿÑnà–B[d«e«×—Ë|7±/*e“ˆğ5Ê/Üy"¼Š;Ç{u¾wyŸŸäµĞ6u§¸ŸöPî{ŸN#Ë;Úk™Q=%0‚’°iKX]ÔuÊf¤c-}r½Çşi	h[_›’Şºà^3¥è†W‚¿‰xvW[a:hµ<"˜ıa şvîÚÔ.¦>i–¶¥ªİÒ˜½­t½òvşh_ü.EvO×€7°å±£SZâkô°ß„¶|š…õXö)fDÎOÒ•†üT“øÛ>;¨ÊàösÈ¿FÇÁïu–wË¥e>´õƒóí]Í*¨Ôò/y’*EsÔ'I)µkø´•B¥‹Ä0YÇ(„ŠåÁ£©9« Ym°@%ÌQ¤ómÆé@ê´àÂğ@ìÄK@µ-€ßFA‘TzÊ©-ÀÇ÷#<şiº[¿D|#¥x³¼Æ7€À{¬İ.c€Ğ7qnÍêÀeÛKö—’„[4)£€¶Ò»Îó.Öã ´èl³ûó0µwàW/splÕ5–aå;Ï@¢é@B“ã*@5ÁìT72ÿ]’È†¸ŒıëY1õ€+ÎC”#sªkXLñxàk†æ5ÿKì2ñ¼¬Š ;õ±‘d’~ÑŸyÜ®¹ı@@«ì ¶*D˜ÙšÊ73Ñ¦rëeµä$Uè‚'˜óôöŒOM•ò”mógŒ+Ø]nÕÛÚ!G«ÃCÙ)IŞ¸ –tF\¸7kƒûĞ¡pXXTß¾ïËÕöœ„;O	¨jÉşñ´ŞrVPtu¶–7¿Ï[¾¾düwq!İ9›¯K"Øbè3¥¼:]Ñ/¥°,_"ÙĞ>UÏ2Šbı*—P#‘—´ŠCH#e4³®âBE§¸»!ïX2bkünxìŠ$CÖSPæN1üQ4p^&4ÿCÀµ·f_ø2RØû5¡¨¤Š¸tRM´M÷ç±bRÄÁ¸[\ àı3‚D$?“ós%=0|¸0qV³d„¶Ç‹ «Û97R8M=§øwÊù…ê¥Í$›û¨Ïác!	YPK*¬¨Om}13øÍˆ=R@7w¨ö9Çl` ùÄôù†	)üØ@×à¡Àºã7İ5_org_lwjgl_opengl_GL33_nglVertexAttribP3uiv(JNIEnv *env, jclass clazz, jint index, jint type, jboolean normalized, jlong value, jlong function_pointer) {
	const GLuint *value_address = (const GLuint *)(intptr_t)value;
	glVertexAttribP3uivPROC glVertexAttribP3uiv = (glVertexAttribP3uivPROC)((intptr_t)function_pointer);
	glVertexAttribP3uiv(index, type, normalized, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_GL33_nglVertexAttribP4uiv(JNIEnv *env, jclass clazz, jint index, jint type, jboolean normalized, jlong value, jlong function_pointer) {
	const GLuint *value_address = (const GLuint *)(intptr_t)value;
	glVertexAttribP4uivPROC glVertexAttribP4uiv = (glVertexAttribP4uivPROC)((intptr_t)function_pointer);
	glVertexAttribP4uiv(index, type, normalized, value_address);
}

