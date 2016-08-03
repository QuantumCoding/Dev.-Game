/* MACHINE GENERATED FILE, DO NOT EDIT */

#include <jni.h>
#include "extgl.h"

typedef void (APIENTRY *glClientAttribDefaultEXTPROC) (GLbitfield mask);
typedef void (APIENTRY *glPushClientAttribDefaultEXTPROC) (GLbitfield mask);
typedef void (APIENTRY *glMatrixLoadfEXTPROC) (GLenum matrixMode, const GLfloat * m);
typedef void (APIENTRY *glMatrixLoaddEXTPROC) (GLenum matrixMode, const GLdouble * m);
typedef void (APIENTRY *glMatrixMultfEXTPROC) (GLenum matrixMode, const GLfloat * m);
typedef void (APIENTRY *glMatrixMultdEXTPROC) (GLenum matrixMode, const GLdouble * m);
typedef void (APIENTRY *glMatrixLoadIdentityEXTPROC) (GLenum matrixMode);
typedef void (APIENTRY *glMatrixRotatefEXTPROC) (GLenum matrixMode, GLfloat angle, GLfloat x, GLfloat y, GLfloat z);
typedef void (APIENTRY *glMatrixRotatedEXTPROC) (GLenum matrixMode, GLdouble angle, GLdouble x, GLdouble y, GLdouble z);
typedef void (APIENTRY *glMatrixScalefEXTPROC) (GLenum matrixMode, GLfloat x, GLfloat y, GLfloat z);
typedef void (APIENTRY *glMatrixScaledEXTPROC) (GLenum matrixMode, GLdouble x, GLdouble y, GLdouble z);
typedef void (APIENTRY *glMatrixTranslatefEXTPROC) (GLenum matrixMode, GLfloat x, GLfloat y, GLfloat z);
typedef void (APIENTRY *glMatrixTranslatedEXTPROC) (GLenum matrixMode, GLdouble x, GLdouble y, GLdouble z);
typedef void (APIENTRY *glMatrixOrthoEXTPROC) (GLenum matrixMode, GLdouble l, GLdouble r, GLdouble b, GLdouble t, GLdouble n, GLdouble f);
typedef void (APIENTRY *glMatrixFrustumEXTPROC) (GLenum matrixMode, GLdouble l, GLdouble r, GLdouble b, GLdouble t, GLdouble n, GLdouble f);
typedef void (APIENTRY *glMatrixPushEXTPROC) (GLenum matrixMode);
typedef void (APIENTRY *glMatrixPopEXTPROC) (GLenum matrixMode);
typedef void (APIENTRY *glTextureParameteriEXTPROC) (GLuint texture, GLenum target, GLenum pname, GLint param);
typedef void (APIENTRY *glTextureParameterivEXTPROC) (GLuint texture, GLenum target, GLenum pname, const GLint * param);
typedef void (APIENTRY *glTextureParameterfEXTPROC) (GLuint texture, GLenum target, GLenum pname, GLfloat param);
typedef void (APIENTRY *glTextureParameterfvEXTPROC) (GLuint texture, GLenum target, GLenum pname, const GLfloat * param);
typedef void (APIENTRY *glTextureImage1DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint internalformat, GLsizei width, GLint border, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glTextureImage2DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint internalformat, GLsizei width, GLsizei height, GLint border, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glTextureSubImage1DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint xoffset, GLsizei width, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glTextureSubImage2DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLsizei width, GLsizei height, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glCopyTextureImage1DEXTPROC) (GLuint texture, GLenum target, GLint level, GLenum internalformat, GLint x, GLint y, GLsizei width, GLint border);
typedef void (APIENTRY *glCopyTextureImage2DEXTPROC) (GLuint texture, GLenum target, GLint level, GLenum internalformat, GLint x, GLint y, GLsizei width, GLsizei height, GLint border);
typedef void (APIENTRY *glCopyTextureSubImage1DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint xoffset, GLint x, GLint y, GLsizei width);
typedef void (APIENTRY *glCopyTextureSubImage2DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint x, GLint y, GLsizei width, GLsizei height);
typedef void (APIENTRY *glGetTextureImageEXTPROC) (GLuint texture, GLenum target, GLint level, GLenum format, GLenum type, GLvoid * pixels);
typedef void (APIENTRY *glGetTextureParameterfvEXTPROC) (GLuint texture, GLenum target, GLenum pname, GLfloat * params);
typedef void (APIENTRY *glGetTextureParameterivEXTPROC) (GLuint texture, GLenum target, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetTextureLevelParameterfvEXTPROC) (GLuint texture, GLenum target, GLint level, GLenum pname, GLfloat * params);
typedef void (APIENTRY *glGetTextureLevelParameterivEXTPROC) (GLuint texture, GLenum target, GLint level, GLenum pname, GLint * params);
typedef void (APIENTRY *glTextureImage3DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint internalformat, GLsizei width, GLsizei height, GLsizei depth, GLint border, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glTextureSubImage3DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint zoffset, GLsizei width, GLsizei height, GLsizei depth, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glCopyTextureSubImage3DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint zoffset, GLint x, GLint y, GLsizei width, GLsizei height);
typedef void (APIENTRY *glBindMultiTextureEXTPROC) (GLenum texunit, GLenum target, GLuint texture);
typedef void (APIENTRY *glMultiTexCoordPointerEXTPROC) (GLenum texunit, GLint size, GLenum type, GLsizei stride, const GLvoid * pointer);
typedef void (APIENTRY *glMultiTexEnvfEXTPROC) (GLenum texunit, GLenum target, GLenum pname, GLfloat param);
typedef void (APIENTRY *glMultiTexEnvfvEXTPROC) (GLenum texunit, GLenum target, GLenum pname, const GLfloat * params);
typedef void (APIENTRY *glMultiTexEnviEXTPROC) (GLenum texunit, GLenum target, GLenum pname, GLint param);
typedef void (APIENTRY *glMultiTexEnvivEXTPROC) (GLenum texunit, GLenum target, GLenum pname, const GLint * params);
typedef void (APIENTRY *glMultiTexGendEXTPROC) (GLenum texunit, GLenum coord, GLenum pname, GLdouble param);
typedef void (APIENTRY *glMultiTexGendvEXTPROC) (GLenum texunit, GLenum coord, GLenum pname, const GLdouble * params);
typedef void (APIENTRY *glMultiTexGenfEXTPROC) (GLenum texunit, GLenum coord, GLenum pname, GLfloat param);
typedef void (APIENTRY *glMultiTexGenfvEXTPROC) (GLenum texunit, GLenum coord, GLenum pname, const GLfloat * params);
typedef void (APIENTRY *glMultiTexGeniEXTPROC) (GLenum texunit, GLenum coord, GLenum pname, GLint param);
typedef void (APIENTRY *glMultiTexGenivEXTPROC) (GLenum texunit, GLenum coord, GLenum pname, const GLint * params);
typedef void (APIENTRY *glGetMultiTexEnvfvEXTPROC) (GLenum texunit, GLenum target, GLenum pname, GLfloat * params);
typedef void (APIENTRY *glGetMultiTexEnvivEXTPROC) (GLenum texunit, GLenum target, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetMultiTexGendvEXTPROC) (GLenum texunit, GLenum coord, GLenum pname, GLdouble * params);
typedef void (APIENTRY *glGetMultiTexGenfvEXTPROC) (GLenum texunit, GLenum coord, GLenum pname, GLfloat * params);
typedef void (APIENTRY *glGetMultiTexGenivEXTPROC) (GLenum texunit, GLenum coord, GLenum pname, GLint * params);
typedef void (APIENTRY *glMultiTexParameteriEXTPROC) (GLenum texunit, GLenum target, GLenum pname, GLint param);
typedef void (APIENTRY *glMultiTexParameterivEXTPROC) (GLenum texunit, GLenum target, GLenum pname, const GLint * param);
typedef void (APIENTRY *glMultiTexParameterfEXTPROC) (GLenum texunit, GLenum target, GLenum pname, GLfloat param);
typedef void (APIENTRY *glMultiTexParameterfvEXTPROC) (GLenum texunit, GLenum target, GLenum pname, const GLfloat * param);
typedef void (APIENTRY *glMultiTexImage1DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint internalformat, GLsizei width, GLint border, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glMultiTexImage2DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint internalformat, GLsizei width, GLsizei height, GLint border, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glMultiTexSubImage1DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint xoffset, GLsizei width, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glMultiTexSubImage2DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLsizei width, GLsizei height, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glCopyMultiTexImage1DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLenum internalformat, GLint x, GLint y, GLsizei width, GLint border);
typedef void (APIENTRY *glCopyMultiTexImage2DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLenum internalformat, GLint x, GLint y, GLsizei width, GLsizei height, GLint border);
typedef void (APIENTRY *glCopyMultiTexSubImage1DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint xoffset, GLint x, GLint y, GLsizei width);
typedef void (APIENTRY *glCopyMultiTexSubImage2DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint x, GLint y, GLsizei width, GLsizei height);
typedef void (APIENTRY *glGetMultiTexImageEXTPROC) (GLenum texunit, GLenum target, GLint level, GLenum format, GLenum type, GLvoid * pixels);
typedef void (APIENTRY *glGetMultiTexParameterfvEXTPROC) (GLenum texunit, GLenum target, GLenum pname, GLfloat * params);
typedef void (APIENTRY *glGetMultiTexParameterivEXTPROC) (GLenum texunit, GLenum target, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetMultiTexLevelParameterfvEXTPROC) (GLenum texunit, GLenum target, GLint level, GLenum pname, GLfloat * params);
typedef void (APIENTRY *glGetMultiTexLevelParameterivEXTPROC) (GLenum texunit, GLenum target, GLint level, GLenum pname, GLint * params);
typedef void (APIENTRY *glMultiTexImage3DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint internalformat, GLsizei width, GLsizei height, GLsizei depth, GLint border, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glMultiTexSubImage3DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint zoffset, GLsizei width, GLsizei height, GLsizei depth, GLenum format, GLenum type, const GLvoid * pixels);
typedef void (APIENTRY *glCopyMultiTexSubImage3DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint zoffset, GLint x, GLint y, GLsizei width, GLsizei height);
typedef void (APIENTRY *glEnableClientStateIndexedEXTPROC) (GLenum array, GLuint index);
typedef void (APIENTRY *glDisableClientStateIndexedEXTPROC) (GLenum array, GLuint index);
typedef void (APIENTRY *glEnableClientStateiEXTPROC) (GLenum array, GLuint index);
typedef void (APIENTRY *glDisableClientStateiEXTPROC) (GLenum array, GLuint index);
typedef void (APIENTRY *glGetFloatIndexedvEXTPROC) (GLenum pname, GLuint index, GLfloat * params);
typedef void (APIENTRY *glGetDoubleIndexedvEXTPROC) (GLenum pname, GLuint index, GLdouble * params);
typedef void (APIENTRY *glGetPointerIndexedvEXTPROC) (GLenum pname, GLuint index, GLvoid ** params);
typedef void (APIENTRY *glGetFloati_vEXTPROC) (GLenum pname, GLuint index, GLfloat * params);
typedef void (APIENTRY *glGetDoublei_vEXTPROC) (GLenum pname, GLuint index, GLdouble * params);
typedef void (APIENTRY *glGetPointeri_vEXTPROC) (GLenum pname, GLuint index, GLvoid ** params);
typedef void (APIENTRY *glNamedProgramStringEXTPROC) (GLuint program, GLenum target, GLenum format, GLsizei len, const GLvoid * string);
typedef void (APIENTRY *glNamedProgramLocalParameter4dEXTPROC) (GLuint program, GLenum target, GLuint index, GLdouble x, GLdouble y, GLdouble z, GLdouble w);
typedef void (APIENTRY *glNamedProgramLocalParameter4dvEXTPROC) (GLuint program, GLenum target, GLuint index, const GLdouble * params);
typedef void (APIENTRY *glNamedProgramLocalParameter4fEXTPROC) (GLuint program, GLenum target, GLuint index, GLfloat x, GLfloat y, GLfloat z, GLfloat w);
typedef void (APIENTRY *glNamedProgramLocalParameter4fvEXTPROC) (GLuint program, GLenum target, GLuint index, const GLfloat * params);
typedef void (APIENTRY *glGetNamedProgramLocalParameterdvEXTPROC) (GLuint program, GLenum target, GLuint index, GLdouble * params);
typedef void (APIENTRY *glGetNamedProgramLocalParameterfvEXTPROC) (GLuint program, GLenum target, GLuint index, GLfloat * params);
typedef void (APIENTRY *glGetNamedProgramivEXTPROC) (GLuint program, GLenum target, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetNamedProgramStringEXTPROC) (GLuint program, GLenum target, GLenum pname, GLvoid * string);
typedef void (APIENTRY *glCompressedTextureImage3DEXTPROC) (GLuint texture, GLenum target, GLint level, GLenum internalformat, GLsizei width, GLsizei height, GLsizei depth, GLint border, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glCompressedTextureImage2DEXTPROC) (GLuint texture, GLenum target, GLint level, GLenum internalformat, GLsizei width, GLsizei height, GLint border, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glCompressedTextureImage1DEXTPROC) (GLuint texture, GLenum target, GLint level, GLenum internalformat, GLsizei width, GLint border, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glCompressedTextureSubImage3DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint zoffset, GLsizei width, GLsizei height, GLsizei depth, GLenum format, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glCompressedTextureSubImage2DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLsizei width, GLsizei height, GLenum format, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glCompressedTextureSubImage1DEXTPROC) (GLuint texture, GLenum target, GLint level, GLint xoffset, GLsizei width, GLenum format, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glGetCompressedTextureImageEXTPROC) (GLuint texture, GLenum target, GLint level, GLvoid * img);
typedef void (APIENTRY *glCompressedMultiTexImage3DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLenum internalformat, GLsizei width, GLsizei height, GLsizei depth, GLint border, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glCompressedMultiTexImage2DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLenum internalformat, GLsizei width, GLsizei height, GLint border, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glCompressedMultiTexImage1DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLenum internalformat, GLsizei width, GLint border, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glCompressedMultiTexSubImage3DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint zoffset, GLsizei width, GLsizei height, GLsizei depth, GLenum format, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glCompressedMultiTexSubImage2DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint xoffset, GLint yoffset, GLsizei width, GLsizei height, GLenum format, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glCompressedMultiTexSubImage1DEXTPROC) (GLenum texunit, GLenum target, GLint level, GLint xoffset, GLsizei width, GLenum format, GLsizei imageSize, const GLvoid * data);
typedef void (APIENTRY *glGetCompressedMultiTexImageEXTPROC) (GLenum texunit, GLenum target, GLint level, GLvoid * img);
typedef void (APIENTRY *glMatrixLoadTransposefEXTPROC) (GLenum matrixMode, const GLfloat * m);
typedef void (APIENTRY *glMatrixLoadTransposedEXTPROC) (GLenum matrixMode, const GLdouble * m);
typedef void (APIENTRY *glMatrixMultTransposefEXTPROC) (GLenum matrixMode, const GLfloat * m);
typedef void (APIENTRY *glMatrixMultTransposedEXTPROC) (GLenum matrixMode, const GLdouble * m);
typedef void (APIENTRY *glNamedBufferDataEXTPROC) (GLuint buffer, GLsizeiptr size, const GLvoid * data, GLenum usage);
typedef void (APIENTRY *glNamedBufferSubDataEXTPROC) (GLuint buffer, GLintptr offset, GLsizeiptr size, const GLvoid * data);
typedef GLvoid * (APIENTRY *glMapNamedBufferEXTPROC) (GLuint buffer, GLenum access);
typedef GLboolean (APIENTRY *glUnmapNamedBufferEXTPROC) (GLuint buffer);
typedef void (APIENTRY *glGetNamedBufferParameterivEXTPROC) (GLuint buffer, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetNamedBufferPointervEXTPROC) (GLuint buffer, GLenum pname, GLvoid ** params);
typedef void (APIENTRY *glGetNamedBufferSubDataEXTPROC) (GLuint buffer, GLintptr offset, GLsizeiptr size, GLvoid * data);
typedef void (APIENTRY *glProgramUniform1fEXTPROC) (GLuint program, GLint location, GLfloat v0);
typedef void (APIENTRY *glProgramUniform2fEXTPROC) (GLuint program, GLint location, GLfloat v0, GLfloat v1);
typedef void (APIENTRY *glProgramUniform3fEXTPROC) (GLuint program, GLint location, GLfloat v0, GLfloat v1, GLfloat v2);
typedef void (APIENTRY *glProgramUniform4fEXTPROC) (GLuint program, GLint location, GLfloat v0, GLfloat v1, GLfloat v2, GLfloat v3);
typedef void (APIENTRY *glProgramUniform1iEXTPROC) (GLuint program, GLint location, GLint v0);
typedef void (APIENTRY *glProgramUniform2iEXTPROC) (GLuint program, GLint location, GLint v0, GLint v1);
typedef void (APIENTRY *glProgramUniform3iEXTPROC) (GLuint program, GLint location, GLint v0, GLint v1, GLint v2);
typedef void (APIENTRY *glProgramUniform4iEXTPROC) (GLuint program, GLint location, GLint v0, GLint v1, GLint v2, GLint v3);
typedef void (APIENTRY *glProgramUniform1fvEXTPROC) (GLuint program, GLint location, GLsizei count, const GLfloat * value);
typedef void (APIENTRY *glProgramUniform2fvEXTPROC) (GLuint program, GLint location, GLsizei count, const GLfloat * value);
typedef void (APIENTRY *glProgramUniform3fvEXTPROC) (GLuint program, GLint location, GLsizei count, const GLfloat * value);
typedef void (APIENTRY *glProgramUniform4fvEXTPROC) (GLuint program, GLint location, GLsizei count, const GLfloat * value);
typedef void (APIENTRY *glProgramUniform1ivEXTPROC) (GLuint program, GLint location, GLsizei count, const GLint * value);
typedef void (APIENTRY *glProgramUniform2ivEXTPROC) (GLuint program, GLint location, GLsizei count, const GLint * value);
typedef void (APIENTRY *glProgramUniform3ivEXTPROC) (GLuint program, GLint location, GLsizei count, const GLint * value);
typedef void (APIENTRY *glProgramUniform4ivEXTPROC) (GLuint program, GLint location, GLsizei count, const GLint * value);
typedef void (APIENTRY *glProgramUniformMatrix2fvEXTPROC) (GLuint program, GLint location, GLsizei count, GLboolean transpose, const GLfloat * value);
typedef void (APIENTRY *glProgramUniformMatrix3fvEXTPROC) (GLuint program, GLint location, GLsizei count, GLboolean transpose, const GLfloat * value);
typedef void (APIENTRY *glProgramUniformMatrix4fvEXTPROC) (GLuint program, GLint location, GLsizei count, GLboolean transpose, const GLfloat * value);
typedef void (APIENTRY *glProgramUniformMatrix2x3fvEXTPROC) (GLuint program, GLint location, GLsizei count, GLboolean transpose, const GLfloat * value);
typedef void (APIENTRY *glProgramUniformMatrix3x2fvEXTPROC) (GLuint program, GLint location, GLsizei count, GLboolean transpose, const GLfloat * value);
typedef void (APIENTRY *glProgramUniformMatrix2x4fvEXTPROC) (GLuint program, GLint location, GLsizei count, GLboolean transpose, const GLfloat * value);
typedef void (APIENTRY *glProgramUniformMatrix4x2fvEXTPROC) (GLuint program, GLint location, GLsizei count, GLboolean transpose, const GLfloat * value);
typedef void (APIENTRY *glProgramUniformMatrix3x4fvEXTPROC) (GLuint program, GLint location, GLsizei count, GLboolean transpose, const GLfloat * value);
typedef void (APIENTRY *glProgramUniformMatrix4x3fvEXTPROC) (GLuint program, GLint location, GLsizei count, GLboolean transpose, const GLfloat * value);
typedef void (APIENTRY *glTextureBufferEXTPROC) (GLuint texture, GLenum target, GLenum internalformat, GLuint buffer);
typedef void (APIENTRY *glMultiTexBufferEXTPROC) (GLenum texunit, GLenum target, GLenum internalformat, GLuint buffer);
typedef void (APIENTRY *glTextureParameterIivEXTPROC) (GLuint texture, GLenum target, GLenum pname, const GLint * params);
typedef void (APIENTRY *glTextureParameterIuivEXTPROC) (GLuint texture, GLenum target, GLenum pname, const GLuint * params);
typedef void (APIENTRY *glGetTextureParameterIivEXTPROC) (GLuint texture, GLenum target, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetTextureParameterIuivEXTPROC) (GLuint texture, GLenum target, GLenum pname, GLuint * params);
typedef void (APIENTRY *glMultiTexParameterIivEXTPROC) (GLenum texunit, GLenum target, GLenum pname, const GLint * params);
typedef void (APIENTRY *glMultiTexParameterIuivEXTPROC) (GLenum texunit, GLenum target, GLenum pname, const GLuint * params);
typedef void (APIENTRY *glGetMultiTexParameterIivEXTPROC) (GLenum texunit, GLenum target, GLenum pname, GLint * params);
typedef void (APIENTRY *glGetMultiTexParameterIuivEXTPROC) (GLenum texunit, GLenum target, GLenum pname, GLuint * params);
typedef void (APIENTRY *glProgramUniform1uiEXTPROC) (GLuint program, GLint location, GLuint v0);
typedef void (APIENTRY *glProgramUniform2uiEXTPROC) (GLuint program, GLint location, GLuint v0, GLuint v1);
typedef void (APIENTRY *glProgramUniform3uiEXTPROC) (GLuint program, GLint location, GLuint v0, GLuint v1, GLuint v2);
typedef void (APIENTRY *glProgramUniform4uiEXTPROC) (GLuint program, GLint location, GLuint v0, GLuint v1, GLuint v2, GLuint v3);
typedef void (APIENTRY *glProgramUniform1uivEXTPROC) (GLuint program, GLint location, GLsizei count, const GLuint * value);
typedef void (APIENTRY *glProgramUniform2uivEXTPROC) (GLuint program, GLint location, GLsizei count, const GLuint * value);
typedef void (APIENTRY *glProgramUniform3uivEXTPROC) (GLuint program, GLint location, GLsizei count, const GLuint * value);
typedef void (APIENTRY *glProgramUniform4uivEXTPROC) (GLuint program, GLint location, GLsizei count, const GLuint * value);
typedef void (APIENTRY *glNamedProgramLocalParameters4fvEXTPROC) (GLuint program, GLenum target, GLuint index, GLsizei count, const GLfloat * params);
typedef void (APIENTRY *glNamedProgramLocalParameterI4iEXTPROC) (GLuint program, GLenum target, GLuint index, GLint x, GLint y, GLint z, GLint w);
typedef void (APIENTRY *glNamedProgramLocalParameterI4ivEXTPROC) (GLuint program, GLenum target, GLuint index, const GLint * params);
typedef void (APIENTRY *glNamedProgramLocalParametersI4ivEXTPROC) (GLuint program, GLenum target, GLuint index, GLsizei count, const GLint * params);
typedef void (APIENTRY *glNamedProgramLocalParameterI4uiEXTPROC) (GLuint program, GLenum target, GLuint index, GLuint x, GLuint y, GLuint z, GLuint w);
typedef void (APIENTRY *glNamedProgramLocalParameterI4uivEXTPROC) (GLuint program, GLenum target, GLuint index, const GLuint * params);
typedef void (APIENTRY *glNamedProgramLocalParametersI4uivEXTPROC) (GLuint program, GLenum target, GLuint index, GLsizei count, const GLuint * params);
typedef void (APIENTRY *glGetNamedProgramLocalParameterIivEXTPROC) (GLuint program, GLenum target, GLuint index, GLint * params);
typedef void (APIENTRY *glGetNamedProgramLocalParameterIuivEXTPROC) (GLuint program, GLenum target, GLuint index, GLuint * params);
typedef void (APIENTRY *glNamedRenderbufferStorageEXTPROC) (GLuint renderbuffer, GLenum internalformat, GLsizei width, GLsizei height);
typedef void (APIENTRY *glGetNamedRenderbufferParameterivEXTPROC) (GLuint renderbuffer, GLenum pname, GLint * params);
typedef void (APIENTRY *glNamedRenderbufferStorageMultisampleEXTPROC) (GLuint renderbuffer, GLsizei samples, GLenum internalformat, GLsizei width, GLsizei height);
typedef void (APIENTRY *glNamedRenderbufferStorageMultisampleCoverageEXTPROC) (GLuint renderbuffer, GLsizei coverageSamples, GLsizei colorSamples, GLenum internalformat, GLsizei width, GLsizei height);
typedef GLenum (APIENTRY *glCheckNamedFramebufferStatusEXTPROC) (GLuint framebuffer, GLenum target);
typedef void (APIENTRY *glNamedFramebufferTexture1DEXTPROC) (GLuint framebuffer, GLenum attachment, GLenum textarget, GLuint texture, GLint level);
typedef void (APIENTRY *glNamedFramebufferTexture2DEXTPROC) (GLuint framebuffer, GLenum attachment, GLenum textarget, GLuint texture, GLint level);
typedef void (APIENTRY *glNamedFramebufferTexture3DEXTPROC) (GLuint framebuffer, GLenum attachment, GLenum textarget, GLuint texture, GLint level, GLint zoffset);
typedef void (APIENTRY *glNamedFramebufferRenderbufferEXTPROC) (GLuint framebuffer, GLenum attachment, GLenum renderbuffertarget, GLuint renderbuffer);
typedef void (APIENTRY *glGetNamedFramebufferAttachmentParameterivEXTPROC) (GLuint framebuffer, GLenum attachment, GLenum pname, GLint * params);
typedef void (APIENTRY *glGenerateTextureMipmapEXTPROC) (GLuint texture, GLenum target);
typedef void (APIENTRY *glGenerateMultiTexMipmapEXTPROC) (GLenum texunit, GLenum target);
typedef void (APIENTRY *glFramebufferDrawBufferEXTPROC) (GLuint framebuffer, GLenum mode);
typedef void (APIENTRY *glFramebufferDrawBuffersEXTPROC) (GLuint framebuffer, GLsizei n, const GLenum * bufs);
typedef void (APIENTRY *glFramebufferReadBufferEXTPROC) (GLuint framebuffer, GLenum mode);
typedef void (APIENTRY *glGetFramebufferParameterivEXTPROC) (GLuint framebuffer, GLenum pname, GLint * param);
typedef void (APIENTRY *glNamedCopyBufferSubDataEXTPROC) (GLuint readBuffer, GLuint writeBuffer, GLintptr readoffset, GLintptr writeoffset, GLsizeiptr size);
typedef void (APIENTRY *glNamedFramebufferTextureEXTPROC) (GLuint framebuffer, GLenum attachment, GLuint texture, GLint level);
typedef void (APIENTRY *glNamedFramebufferTextureLayerEXTPROC) (GLuint framebuffer, GLenum attachment, GLuint texture, GLint level, GLint layer);
typedef void (APIENTRY *glNamedFramebufferTextureFaceEXTPROC) (GLuint framebuffer, GLenum attachment, GLuint texture, GLint level, GLenum face);
typedef void (APIENTRY *glTextureRenderbufferEXTPROC) (GLuint texture, GLenum target, GLuint renderbuffer);
typedef void (APIENTRY *glMultiTexRenderbufferEXTPROC) (GLenum texunit, GLenum target, GLuint renderbuffer);
typedef void (APIENTRY *glVertexArrayVertexOffsetEXTPROC) (GLuint vaobj, GLuint buffer, GLint size, GLenum type, GLsizei stride, GLintptr offset);
typedef void (APIENTRY *glVertexArrayColorOffsetEXTPROC) (GLuint vaobj, GLuint buffer, GLint size, GLenum type, GLsizei stride, GLintptr offset);
typedef void (APIENTRY *glVertexArrayEdgeFlagOffsetEXTPROC) (GLuint vaobj, GLuint buffer, GLsizei stride, GLintptr offset);
typedef void (APIENTRY *glVertexArrayIndexOffsetEXTPROC) (GLuint vaobj, GLuint buffer, GLenum type, GLsizei stride, GLintptr offset);
typedef void (APIENTRY *glVertexArrayNormalOffsetEXTPROC) (GLuint vaobj, GLuint buffer, GLenum type, GLsizei stride, GLintptr offset);
typedef void (APIENTRY *glVertexArrayTexCoordOffsetEXTPROC) (GLuint vaobj, GLuint buffer, GLint size, GLenum type, GLsizei stride, GLintptr offset);
typedef void (APIENTRY *glVertexArrayMultiTexCoordOffsetEXTPROC) (GLuint vaobj, GLuint buffer, GLenum texunit, GLint size, GLenum type, GLsizei stride, GLintptr offset);
typedef void (APIENTRY *glVertexArrayFogCoordOffsetEXTPROC) (GLuint vaobj, GLuint buffer, GLenum type, GLsizei stride, GLintptr offset);
typedef void (APIENTRY *glVertexArraySecondaryColorOffsetEXTPROC) (GLuint vaobj, GLuint buffer, GLint size, GLenum type, GLsizei stride, GLintptr offset);
typedef void (APIENTRY *glVertexArrayVertexAttribOffsetEXTPROC) (GLuint vaobj, GLuint buffer, GLuint index, GLint size, GLenum type, GLboolean normalized, GLsizei stride, GLintptr offset);
typedef void (APIENTRY *glVertexArrayVertexAttribIOffsetEXTPROC) (GLuint vaobj, GLuint buffer, GLuint index, GLint size, GLenum type, GLsizei stride, GLintptr offset);
typedef void (APIENTRY *glEnableVertexArrayEXTPROC) (GLuint vaobj, GLenum array);
typedef void (APIENTRY *glDisableVertexArrayEXTPROC) (GLuint vaobj, GLenum array);
typedef void (APIENTRY *glEnableVertexArrayAttribEXTPROC) (GLuint vaobj, GLuint index);
typedef void (APIENTRY *glDisableVertexArrayAttribEXTPROC) (GLuint vaobj, GLuint index);
typedef void (APIENTRY *glGetVertexArrayIntegervEXTPROC) (GLuint vaobj, GLenum pname, GLint * param);
typedef void (APIENTRY *glGetVertexArrayPointervEXTPROC) (GLuint vaobj, GLenum pname, GLvoid ** param);
typedef void (APIENTRY *glGetVertexArrayIntegeri_vEXTPROC) (GLuint vaobj, GLuint index, GLenum pname, GLint * param);
typedef void (APIENTRY *glGetVertexArrayPointeri_vEXTPROC) (GLuint vaobj, GLuint index, GLenum pname, GLvoid ** param);
typedef GLvoid * (APIENTRY *glMapNamedBufferRangeEXTPROC) (GLuint buffer, GLintptr offset, GLsizeiptr length, GLbitfield access);
typedef void (APIENTRY *glFlushMappedNamedBufferRangeEXTPROC) (GLuint buffer, GLintptr offset, GLsizeiptr length);

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglClientAttribDefaultEXT(JNIEnv *env, jclass clazz, jint mask, jlong function_pointer) {
	glClientAttribDefaultEXTPROC glClientAttribDefaultEXT = (glClientAttribDefaultEXTPROC)((intptr_t)function_pointer);
	glClientAttribDefaultEXT(mask);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglPushClientAttribDefaultEXT(JNIEnv *env, jclass clazz, jint mask, jlong function_pointer) {
	glPushClientAttribDefaultEXTPROC glPushClientAttribDefaultEXT = (glPushClientAttribDefaultEXTPROC)((intptr_t)function_pointer);
	glPushClientAttribDefaultEXT(mask);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixLoadfEXT(JNIEnv *env, jclass clazz, jint matrixMode, jlong m, jlong function_pointer) {
	const GLfloat *m_address = (const GLfloat *)(intptr_t)m;
	glMatrixLoadfEXTPROC glMatrixLoadfEXT = (glMatrixLoadfEXTPROC)((intptr_t)function_pointer);
	glMatrixLoadfEXT(matrixMode, m_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixLoaddEXT(JNIEnv *env, jclass clazz, jint matrixMode, jlong m, jlong function_pointer) {
	const GLdouble *m_address = (const GLdouble *)(intptr_t)m;
	glMatrixLoaddEXTPROC glMatrixLoaddEXT = (glMatrixLoaddEXTPROC)((intptr_t)function_pointer);
	glMatrixLoaddEXT(matrixMode, m_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixMultfEXT(JNIEnv *env, jclass clazz, jint matrixMode, jlong m, jlong function_pointer) {
	const GLfloat *m_address = (const GLfloat *)(intptr_t)m;
	glMatrixMultfEXTPROC glMatrixMultfEXT = (glMatrixMultfEXTPROC)((intptr_t)function_pointer);
	glMatrixMultfEXT(matrixMode, m_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixMultdEXT(JNIEnv *env, jclass clazz, jint matrixMode, jlong m, jlong function_pointer) {
	const GLdouble *m_address = (const GLdouble *)(intptr_t)m;
	glMatrixMultdEXTPROC glMatrixMultdEXT = (glMatrixMultdEXTPROC)((intptr_t)function_pointer);
	glMatrixMultdEXT(matrixMode, m_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixLoadIdentityEXT(JNIEnv *env, jclass clazz, jint matrixMode, jlong function_pointer) {
	glMatrixLoadIdentityEXTPROC glMatrixLoadIdentityEXT = (glMatrixLoadIdentityEXTPROC)((intptr_t)function_pointer);
	glMatrixLoadIdentityEXT(matrixMode);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixRotatefEXT(JNIEnv *env, jclass clazz, jint matrixMode, jfloat angle, jfloat x, jfloat y, jfloat z, jlong function_pointer) {
	glMatrixRotatefEXTPROC glMatrixRotatefEXT = (glMatrixRotatefEXTPROC)((intptr_t)function_pointer);
	glMatrixRotatefEXT(matrixMode, angle, x, y, z);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixRotatedEXT(JNIEnv *env, jclass clazz, jint matrixMode, jdouble angle, jdouble x, jdouble y, jdouble z, jlong function_pointer) {
	glMatrixRotatedEXTPROC glMatrixRotatedEXT = (glMatrixRotatedEXTPROC)((intptr_t)function_pointer);
	glMatrixRotatedEXT(matrixMode, angle, x, y, z);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixScalefEXT(JNIEnv *env, jclass clazz, jint matrixMode, jfloat x, jfloat y, jfloat z, jlong function_pointer) {
	glMatrixScalefEXTPROC glMatrixScalefEXT = (glMatrixScalefEXTPROC)((intptr_t)function_pointer);
	glMatrixScalefEXT(matrixMode, x, y, z);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixScaledEXT(JNIEnv *env, jclass clazz, jint matrixMode, jdouble x, jdouble y, jdouble z, jlong function_pointer) {
	glMatrixScaledEXTPROC glMatrixScaledEXT = (glMatrixScaledEXTPROC)((intptr_t)function_pointer);
	glMatrixScaledEXT(matrixMode, x, y, z);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixTranslatefEXT(JNIEnv *env, jclass clazz, jint matrixMode, jfloat x, jfloat y, jfloat z, jlong function_pointer) {
	glMatrixTranslatefEXTPROC glMatrixTranslatefEXT = (glMatrixTranslatefEXTPROC)((intptr_t)function_pointer);
	glMatrixTranslatefEXT(matrixMode, x, y, z);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixTranslatedEXT(JNIEnv *env, jclass clazz, jint matrixMode, jdouble x, jdouble y, jdouble z, jlong function_pointer) {
	glMatrixTranslatedEXTPROC glMatrixTranslatedEXT = (glMatrixTranslatedEXTPROC)((intptr_t)function_pointer);
	glMatrixTranslatedEXT(matrixMode, x, y, z);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixOrthoEXT(JNIEnv *env, jclass clazz, jint matrixMode, jdouble l, jdouble r, jdouble b, jdouble t, jdouble n, jdouble f, jlong function_pointer) {
	glMatrixOrthoEXTPROC glMatrixOrthoEXT = (glMatrixOrthoEXTPROC)((intptr_t)function_pointer);
	glMatrixOrthoEXT(matrixMode, l, r, b, t, n, f);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixFrustumEXT(JNIEnv *env, jclass clazz, jint matrixMode, jdouble l, jdouble r, jdouble b, jdouble t, jdouble n, jdouble f, jlong function_pointer) {
	glMatrixFrustumEXTPROC glMatrixFrustumEXT = (glMatrixFrustumEXTPROC)((intptr_t)function_pointer);
	glMatrixFrustumEXT(matrixMode, l, r, b, t, n, f);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixPushEXT(JNIEnv *env, jclass clazz, jint matrixMode, jlong function_pointer) {
	glMatrixPushEXTPROC glMatrixPushEXT = (glMatrixPushEXTPROC)((intptr_t)function_pointer);
	glMatrixPushEXT(matrixMode);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixPopEXT(JNIEnv *env, jclass clazz, jint matrixMode, jlong function_pointer) {
	glMatrixPopEXTPROC glMatrixPopEXT = (glMatrixPopEXTPROC)((intptr_t)function_pointer);
	glMatrixPopEXT(matrixMode);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureParameteriEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint pname, jint param, jlong function_pointer) {
	glTextureParameteriEXTPROC glTextureParameteriEXT = (glTextureParameteriEXTPROC)((intptr_t)function_pointer);
	glTextureParameteriEXT(texture, target, pname, param);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureParameterivEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint pname, jlong param, jlong function_pointer) {
	const GLint *param_address = (const GLint *)(intptr_t)param;
	glTextureParameterivEXTPROC glTextureParameterivEXT = (glTextureParameterivEXTPROC)((intptr_t)function_pointer);
	glTextureParameterivEXT(texture, target, pname, param_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureParameterfEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint pname, jfloat param, jlong function_pointer) {
	glTextureParameterfEXTPROC glTextureParameterfEXT = (glTextureParameterfEXTPROC)((intptr_t)function_pointer);
	glTextureParameterfEXT(texture, target, pname, param);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureParameterfvEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint pname, jlong param, jlong function_pointer) {
	const GLfloat *param_address = (const GLfloat *)(intptr_t)param;
	glTextureParameterfvEXTPROC glTextureParameterfvEXT = (glTextureParameterfvEXTPROC)((intptr_t)function_pointer);
	glTextureParameterfvEXT(texture, target, pname, param_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureImage1DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint border, jint format, jint type, jlong pixels, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)pixels;
	glTextureImage1DEXTPROC glTextureImage1DEXT = (glTextureImage1DEXTPROC)((intptr_t)function_pointer);
	glTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureImage1DEXTBO(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint border, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glTextureImage1DEXTPROC glTextureImage1DEXT = (glTextureImage1DEXTPROC)((intptr_t)function_pointer);
	glTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureImage2DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint height, jint border, jint format, jint type, jlong pixels, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)pixels;
	glTextureImage2DEXTPROC glTextureImage2DEXT = (glTextureImage2DEXTPROC)((intptr_t)function_pointer);
	glTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureImage2DEXTBO(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint height, jint border, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glTextureImage2DEXTPROC glTextureImage2DEXT = (glTextureImage2DEXTPROC)((intptr_t)function_pointer);
	glTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureSubImage1DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint xoffset, jint width, jint format, jint type, jlong pixels, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)pixels;
	glTextureSubImage1DEXTPROC glTextureSubImage1DEXT = (glTextureSubImage1DEXTPROC)((intptr_t)function_pointer);
	glTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureSubImage1DEXTBO(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint xoffset, jint width, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glTextureSubImage1DEXTPROC glTextureSubImage1DEXT = (glTextureSubImage1DEXTPROC)((intptr_t)function_pointer);
	glTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureSubImage2DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint xoffset, jint yoffset, jint width, jint height, jint format, jint type, jlong pixels, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)pixels;
	glTextureSubImage2DEXTPROC glTextureSubImage2DEXT = (glTextureSubImage2DEXTPROC)((intptr_t)function_pointer);
	glTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureSubImage2DEXTBO(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint xoffset, jint yoffset, jint width, jint height, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glTextureSubImage2DEXTPROC glTextureSubImage2DEXT = (glTextureSubImage2DEXTPROC)((intptr_t)function_pointer);
	glTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCopyTextureImage1DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint x, jint y, jint width, jint border, jlong function_pointer) {
	glCopyTextureImage1DEXTPROC glCopyTextureImage1DEXT = (glCopyTextureImage1DEXTPROC)((intptr_t)function_pointer);
	glCopyTextureImage1DEXT(texture, target, level, internalformat, x, y, width, border);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCopyTextureImage2DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint x, jint y, jint width, jint height, jint border, jlong function_pointer) {
	glCopyTextureImage2DEXTPROC glCopyTextureImage2DEXT = (glCopyTextureImage2DEXTPROC)((intptr_t)function_pointer);
	glCopyTextureImage2DEXT(texture, target, level, internalformat, x, y, width, height, border);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCopyTextureSubImage1DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint xoffset, jint x, jint y, jint width, jlong function_pointer) {
	glCopyTextureSubImage1DEXTPROC glCopyTextureSubImage1DEXT = (glCopyTextureSubImage1DEXTPROC)((intptr_t)function_pointer);
	glCopyTextureSubImage1DEXT(texture, target, level, xoffset, x, y, width);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCopyTextureSubImage2DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint xoffset, jint yoffset, jint x, jint y, jint width, jint height, jlong function_pointer) {
	glCopyTextureSubImage2DEXTPROC glCopyTextureSubImage2DEXT = (glCopyTextureSubImage2DEXTPROC)((intptr_t)function_pointer);
	glCopyTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, x, y, width, height);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetTextureImageEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint format, jint type, jlong pixels, jlong function_pointer) {
	GLvoid *pixels_address = (GLvoid *)(intptr_t)pixels;
	glGetTextureImageEXTPROC glGetTextureImageEXT = (glGetTextureImageEXTPROC)((intptr_t)function_pointer);
	glGetTextureImageEXT(texture, target, level, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetTextureImageEXTBO(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	GLvoid *pixels_address = (GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glGetTextureImageEXTPROC glGetTextureImageEXT = (glGetTextureImageEXTPROC)((intptr_t)function_pointer);
	glGetTextureImageEXT(texture, target, level, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetTextureParameterfvEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint pname, jlong params, jlong function_pointer) {
	GLfloat *params_address = (GLfloat *)(intptr_t)params;
	glGetTextureParameterfvEXTPROC glGetTextureParameterfvEXT = (glGetTextureParameterfvEXTPROC)((intptr_t)function_pointer);
	glGetTextureParameterfvEXT(texture, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetTextureParameterivEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetTextureParameterivEXTPROC glGetTextureParameterivEXT = (glGetTextureParameterivEXTPROC)((intptr_t)function_pointer);
	glGetTextureParameterivEXT(texture, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetTextureLevelParameterfvEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint pname, jlong params, jlong function_pointer) {
	GLfloat *params_address = (GLfloat *)(intptr_t)params;
	glGetTextureLevelParameterfvEXTPROC glGetTextureLevelParameterfvEXT = (glGetTextureLevelParameterfvEXTPROC)((intptr_t)function_pointer);
	glGetTextureLevelParameterfvEXT(texture, target, level, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetTextureLevelParameterivEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetTextureLevelParameterivEXTPROC glGetTextureLevelParameterivEXT = (glGetTextureLevelParameterivEXTPROC)((intptr_t)function_pointer);
	glGetTextureLevelParameterivEXT(texture, target, level, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureImage3DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint height, jint depth, jint border, jint format, jint type, jlong pixels, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)pixels;
	glTextureImage3DEXTPROC glTextureImage3DEXT = (glTextureImage3DEXTPROC)((intptr_t)function_pointer);
	glTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureImage3DEXTBO(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint height, jint depth, jint border, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glTextureImage3DEXTPROC glTextureImage3DEXT = (glTextureImage3DEXTPROC)((intptr_t)function_pointer);
	glTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureSubImage3DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint xoffset, jint yoffset, jint zoffset, jint width, jint height, jint depth, jint format, jint type, jlong pixels, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)pixels;
	glTextureSubImage3DEXTPROC glTextureSubImage3DEXT = (glTextureSubImage3DEXTPROC)((intptr_t)function_pointer);
	glTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureSubImage3DEXTBO(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint xoffset, jint yoffset, jint zoffset, jint width, jint height, jint depth, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glTextureSubImage3DEXTPROC glTextureSubImage3DEXT = (glTextureSubImage3DEXTPROC)((intptr_t)function_pointer);
	glTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCopyTextureSubImage3DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint xoffset, jint yoffset, jint zoffset, jint x, jint y, jint width, jint height, jlong function_pointer) {
	glCopyTextureSubImage3DEXTPROC glCopyTextureSubImage3DEXT = (glCopyTextureSubImage3DEXTPROC)((intptr_t)function_pointer);
	glCopyTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, x, y, width, height);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglBindMultiTextureEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint texture, jlong function_pointer) {
	glBindMultiTextureEXTPROC glBindMultiTextureEXT = (glBindMultiTextureEXTPROC)((intptr_t)function_pointer);
	glBindMultiTextureEXT(texunit, target, texture);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexCoordPointerEXT(JNIEnv *env, jclass clazz, jint texunit, jint size, jint type, jint stride, jlong pointer, jlong function_pointer) {
	const GLvoid *pointer_address = (const GLvoid *)(intptr_t)pointer;
	glMultiTexCoordPointerEXTPROC glMultiTexCoordPointerEXT = (glMultiTexCoordPointerEXTPROC)((intptr_t)function_pointer);
	glMultiTexCoordPointerEXT(texunit, size, type, stride, pointer_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexCoordPointerEXTBO(JNIEnv *env, jclass clazz, jint texunit, jint size, jint type, jint stride, jlong pointer_buffer_offset, jlong function_pointer) {
	const GLvoid *pointer_address = (const GLvoid *)(intptr_t)offsetToPointer(pointer_buffer_offset);
	glMultiTexCoordPointerEXTPROC glMultiTexCoordPointerEXT = (glMultiTexCoordPointerEXTPROC)((intptr_t)function_pointer);
	glMultiTexCoordPointerEXT(texunit, size, type, stride, pointer_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexEnvfEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jfloat param, jlong function_pointer) {
	glMultiTexEnvfEXTPROC glMultiTexEnvfEXT = (glMultiTexEnvfEXTPROC)((intptr_t)function_pointer);
	glMultiTexEnvfEXT(texunit, target, pname, param);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexEnvfvEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jlong params, jlong function_pointer) {
	const GLfloat *params_address = (const GLfloat *)(intptr_t)params;
	glMultiTexEnvfvEXTPROC glMultiTexEnvfvEXT = (glMultiTexEnvfvEXTPROC)((intptr_t)function_pointer);
	glMultiTexEnvfvEXT(texunit, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexEnviEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jint param, jlong function_pointer) {
	glMultiTexEnviEXTPROC glMultiTexEnviEXT = (glMultiTexEnviEXTPROC)((intptr_t)function_pointer);
	glMultiTexEnviEXT(texunit, target, pname, param);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexEnvivEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jlong params, jlong function_pointer) {
	const GLint *params_address = (const GLint *)(intptr_t)params;
	glMultiTexEnvivEXTPROC glMultiTexEnvivEXT = (glMultiTexEnvivEXTPROC)((intptr_t)function_pointer);
	glMultiTexEnvivEXT(texunit, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexGendEXT(JNIEnv *env, jclass clazz, jint texunit, jint coord, jint pname, jdouble param, jlong function_pointer) {
	glMultiTexGendEXTPROC glMultiTexGendEXT = (glMultiTexGendEXTPROC)((intptr_t)function_pointer);
	glMultiTexGendEXT(texunit, coord, pname, param);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexGendvEXT(JNIEnv *env, jclass clazz, jint texunit, jint coord, jint pname, jlong params, jlong function_pointer) {
	const GLdouble *params_address = (const GLdouble *)(intptr_t)params;
	glMultiTexGendvEXTPROC glMultiTexGendvEXT = (glMultiTexGendvEXTPROC)((intptr_t)function_pointer);
	glMultiTexGendvEXT(texunit, coord, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexGenfEXT(JNIEnv *env, jclass clazz, jint texunit, jint coord, jint pname, jfloat param, jlong function_pointer) {
	glMultiTexGenfEXTPROC glMultiTexGenfEXT = (glMultiTexGenfEXTPROC)((intptr_t)function_pointer);
	glMultiTexGenfEXT(texunit, coord, pname, param);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexGenfvEXT(JNIEnv *env, jclass clazz, jint texunit, jint coord, jint pname, jlong params, jlong function_pointer) {
	const GLfloat *params_address = (const GLfloat *)(intptr_t)params;
	glMultiTexGenfvEXTPROC glMultiTexGenfvEXT = (glMultiTexGenfvEXTPROC)((intptr_t)function_pointer);
	glMultiTexGenfvEXT(texunit, coord, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexGeniEXT(JNIEnv *env, jclass clazz, jint texunit, jint coord, jint pname, jint param, jlong function_pointer) {
	glMultiTexGeniEXTPROC glMultiTexGeniEXT = (glMultiTexGeniEXTPROC)((intptr_t)function_pointer);
	glMultiTexGeniEXT(texunit, coord, pname, param);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexGenivEXT(JNIEnv *env, jclass clazz, jint texunit, jint coord, jint pname, jlong params, jlong function_pointer) {
	const GLint *params_address = (const GLint *)(intptr_t)params;
	glMultiTexGenivEXTPROC glMultiTexGenivEXT = (glMultiTexGenivEXTPROC)((intptr_t)function_pointer);
	glMultiTexGenivEXT(texunit, coord, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetMultiTexEnvfvEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jlong params, jlong function_pointer) {
	GLfloat *params_address = (GLfloat *)(intptr_t)params;
	glGetMultiTexEnvfvEXTPROC glGetMultiTexEnvfvEXT = (glGetMultiTexEnvfvEXTPROC)((intptr_t)function_pointer);
	glGetMultiTexEnvfvEXT(texunit, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetMultiTexEnvivEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetMultiTexEnvivEXTPROC glGetMultiTexEnvivEXT = (glGetMultiTexEnvivEXTPROC)((intptr_t)function_pointer);
	glGetMultiTexEnvivEXT(texunit, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetMultiTexGendvEXT(JNIEnv *env, jclass clazz, jint texunit, jint coord, jint pname, jlong params, jlong function_pointer) {
	GLdouble *params_address = (GLdouble *)(intptr_t)params;
	glGetMultiTexGendvEXTPROC glGetMultiTexGendvEXT = (glGetMultiTexGendvEXTPROC)((intptr_t)function_pointer);
	glGetMultiTexGendvEXT(texunit, coord, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetMultiTexGenfvEXT(JNIEnv *env, jclass clazz, jint texunit, jint coord, jint pname, jlong params, jlong function_pointer) {
	GLfloat *params_address = (GLfloat *)(intptr_t)params;
	glGetMultiTexGenfvEXTPROC glGetMultiTexGenfvEXT = (glGetMultiTexGenfvEXTPROC)((intptr_t)function_pointer);
	glGetMultiTexGenfvEXT(texunit, coord, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetMultiTexGenivEXT(JNIEnv *env, jclass clazz, jint texunit, jint coord, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetMultiTexGenivEXTPROC glGetMultiTexGenivEXT = (glGetMultiTexGenivEXTPROC)((intptr_t)function_pointer);
	glGetMultiTexGenivEXT(texunit, coord, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexParameteriEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jint param, jlong function_pointer) {
	glMultiTexParameteriEXTPROC glMultiTexParameteriEXT = (glMultiTexParameteriEXTPROC)((intptr_t)function_pointer);
	glMultiTexParameteriEXT(texunit, target, pname, param);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexParameterivEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jlong param, jlong function_pointer) {
	const GLint *param_address = (const GLint *)(intptr_t)param;
	glMultiTexParameterivEXTPROC glMultiTexParameterivEXT = (glMultiTexParameterivEXTPROC)((intptr_t)function_pointer);
	glMultiTexParameterivEXT(texunit, target, pname, param_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexParameterfEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jfloat param, jlong function_pointer) {
	glMultiTexParameterfEXTPROC glMultiTexParameterfEXT = (glMultiTexParameterfEXTPROC)((intptr_t)function_pointer);
	glMultiTexParameterfEXT(texunit, target, pname, param);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexParameterfvEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jlong param, jlong function_pointer) {
	const GLfloat *param_address = (const GLfloat *)(intptr_t)param;
	glMultiTexParameterfvEXTPROC glMultiTexParameterfvEXT = (glMultiTexParameterfvEXTPROC)((intptr_t)function_pointer);
	glMultiTexParameterfvEXT(texunit, target, pname, param_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexImage1DEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint internalformat, jint width, jint border, jint format, jint type, jlong pixels, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)pixels;
	glMultiTexImage1DEXTPROC glMultiTexImage1DEXT = (glMultiTexImage1DEXTPROC)((intptr_t)function_pointer);
	glMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexImage1DEXTBO(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint internalformat, jint width, jint border, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glMultiTexImage1DEXTPROC glMultiTexImage1DEXT = (glMultiTexImage1DEXTPROC)((intptr_t)function_pointer);
	glMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexImage2DEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint internalformat, jint width, jint height, jint border, jint format, jint type, jlong pixels, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)pixels;
	glMultiTexImage2DEXTPROC glMultiTexImage2DEXT = (glMultiTexImage2DEXTPROC)((intptr_t)function_pointer);
	glMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexImage2DEXTBO(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint internalformat, jint width, jint height, jint border, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glMultiTexImage2DEXTPROC glMultiTexImage2DEXT = (glMultiTexImage2DEXTPROC)((intptr_t)function_pointer);
	glMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexSubImage1DEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint width, jint format, jint type, jlong pixels, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)pixels;
	glMultiTexSubImage1DEXTPROC glMultiTexSubImage1DEXT = (glMultiTexSubImage1DEXTPROC)((intptr_t)function_pointer);
	glMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexSubImage1DEXTBO(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint width, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glMultiTexSubImage1DEXTPROC glMultiTexSubImage1DEXT = (glMultiTexSubImage1DEXTPROC)((intptr_t)function_pointer);
	glMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexSubImage2DEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint yoffset, jint width, jint height, jint format, jint type, jlong pixels, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)pixels;
	glMultiTexSubImage2DEXTPROC glMultiTexSubImage2DEXT = (glMultiTexSubImage2DEXTPROC)((intptr_t)function_pointer);
	glMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexSubImage2DEXTBO(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint yoffset, jint width, jint height, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	const GLvoid *pixels_address = (const GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glMultiTexSubImage2DEXTPROC glMultiTexSubImage2DEXT = (glMultiTexSubImage2DEXTPROC)((intptr_t)function_pointer);
	glMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCopyMultiTexImage1DEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint internalformat, jint x, jint y, jint width, jint border, jlong function_pointer) {
	glCopyMultiTexImage1DEXTPROC glCopyMultiTexImage1DEXT = (glCopyMultiTexImage1DEXTPROC)((intptr_t)function_pointer);
	glCopyMultiTexImage1DEXT(texunit, target, level, internalformat, x, y, width, border);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCopyMultiTexImage2DEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint internalformat, jint x, jint y, jint width, jint height, jint border, jlong function_pointer) {
	glCopyMultiTexImage2DEXTPROC glCopyMultiTexImage2DEXT = (glCopyMultiTexImage2DEXTPROC)((intptr_t)function_pointer);
	glCopyMultiTexImage2DEXT(texunit, target, level, internalformat, x, y, width, height, border);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCopyMultiTexSubImage1DEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint x, jint y, jint width, jlong function_pointer) {
	glCopyMultiTexSubImage1DEXTPROC glCopyMultiTexSubImage1DEXT = (glCopyMultiTexSubImage1DEXTPROC)((intptr_t)function_pointer);
	glCopyMultiTexSubImage1DEXT(texunit, target, level, xoffset, x, y, width);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCopyMultiTexSubImage2DEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint yoffset, jint x, jint y, jint width, jint height, jlong function_pointer) {
	glCopyMultiTexSubImage2DEXTPROC glCopyMultiTexSubImage2DEXT = (glCopyMultiTexSubImage2DEXTPROC)((intptr_t)function_pointer);
	glCopyMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, x, y, width, height);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetMultiTexImageEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint format, jint type, jlong pixels, jlong function_pointer) {
	GLvoid *pixels_address = (GLvoid *)(intptr_t)pixels;
	glGetMultiTexImageEXTPROC glGetMultiTexImageEXT = (glGetMultiTexImageEXTPROC)((intptr_t)function_pointer);
	glGetMultiTexImageEXT(texunit, target, level, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetMultiTexImageEXTBO(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint format, jint type, jlong pixels_buffer_offset, jlong function_pointer) {
	GLvoid *pixels_address = (GLvoid *)(intptr_t)offsetToPointer(pixels_buffer_offset);
	glGetMultiTexImageEXTPROC glGetMultiTexImageEXT = (glGetMultiTexImageEXTPROC)((intptr_t)function_pointer);
	glGetMultiTexImageEXT(texunit, target, level, format, type, pixels_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetMultiTexParameterfvEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jlong params, jlong function_pointer) {
	GLfloat *params_address = (GLfloat *)(intptr_t)params;
	glGetMultiTexParameterfvEXTPROC glGetMultiTexParameterfvEXT = (glGetMultiTexParameterfvEXTPROC)((intptr_t)function_pointer);
	glGetMultiT†Ù˜9"úŒ«^'{!NyšÃŞYêqÁn–OAd§õ%'BĞ*‹UPÁúìoO  Ã-KM·Æõ§ìªx5Åy­>ıZC¬æİ‘¯¨á}­âhÙ»®Â‘ìÅa“·…·§ ‹óOhÌÓ æà­xO~ŒV¶„swÛ,£ÊÍÂÉ¾ Ãt„œ†²
™ƒ6äÚŸøñ9JßdëØ~ÀFq(_RN£hõfz²¬G©–ˆÙxÙ@QT´( Ş5‘âa\? p‡×®¯œ|¶O|h˜3=¸é‹j}–?çBÀ­Â;‡¶†Áåz >;ËïÁ²İ¨\xıxÕy²/ÏXÓA¼Nñ9¸™qjº&-İãáàÍ6Ôv¨;u]ÄÒêdá}Æ`û¸İûÛ<ªÃOYíŞlqˆ+É¯H·EŠQ=,Ëd=¹òM$ªs3Ëı³ÎŒtÊ}wÚşdåùTdVÎ­ïUÜz®‡52ĞYÅRmõğàxğëg¹¡&ôôÈbhSÒ‹ËcÈ¤=¹$Gu—ëáîL”·™ƒi½6±¿sƒ¯}QØÊÏşúÃBÅG‘IpÖ+Vx™CœÊ†‡¹Ü©ÉÛÆ{˜@e1*Ìå;™pö».ÂYê6ˆ°½øÓî-(`z‡,4ª‰Z3~°ÌèŸ]3§…ÎÓí*9ª9ê½¡ó×¦acÃË½mDMõP0l{8Ö|­4şô£x»
© ÁğE,ä€qO:¡“´öqŠ„Ä„‰–@bN,ğt5ïdQ#Q·íÍ@\©1ò×v.ë´—õ¼¬t›/bAÖz"~ïS¸7Ø´DI‚[ŞïÜ©ìPI¥/•Ö7±¦lÂÀóâÃÉ¸Dãù¶!TÆcMæ	Æ¦?S!Ñh˜.¥tÔ1ÂûhLÆª–^~#ìÊº¿„ª;î»É¶›vÕ\;ú‘ë>Áâ¯ë«ã° tÙx÷õæXæ>$ø¦6¦x‡eÔ¯'ıT¸i†Š!Í‡—5PÀWÑknöÂ–.pš¯ÉL³Šrª~¹w3¤ë‰HË	T,‡‰1qZÕN™Õ,²`LƒtyÈóJy€¶@)"mAg/vä¸L&N4ÿ–Íà¦Ä³¦>–ˆ€Å[¸¢a€ì ,fKÄªrË#zVBä4ºkOéà¡d„%: -ZJ3ÿòÌ ’ËäËa6WdBjõN») †Ö Ïé’5Cb5şSÿf›•×kà"î§OTÛÍê¹ò£Xª—PUBŒÀYá3J~î*¼Ñ<öÿ[–;¥0!©«ú¥_üK˜‰N¥¥°Ki‘ÄTH8÷±Bi¨eYO¤t‚pÔ=ÈVº*úëİ¿pØ:ã¨c0ò1ÒO¡¶j˜ş–±íç{™ùMv=ô¡Q|Oº†e‰9¡ÍnFÌxŞÉ5Kuù:®\Dú
]V1[p<ˆ1«û¶ÑE¼ 9½E\UçîšuÒ@ªVW´§å1ªÁ‹B¦áœnZUI¼ÄÓå5hcÊ“ÊjU/Álëp&81–CFıÒN3@#?¿X1«è£V¤Ì˜Ú%;İ |ÅæÙE™ÕUIAÅğª[–¹’(Ì¡~ÆNµ1ßá
3ğZVñÈÕ4ÉäJVµ¯D&û‚s¡dWB8
÷}#«5tÓnM‰S¿rÑï]A@¡4Ëê’Ëƒ¶³÷Ã˜l¿-p@¼Âûµ®)Q‡p7b‘7gu‰,„â·–Üìæ U%æÌ0Eõ~ïóê[ÈS&ú_y€>ı½¬“ğâ\­nxÖ~~àF¦äÈ/ªìhèÔ(nRéeâ«”Aei@Z¡-PvS??ëæ€‘¶TÓaå–pŒøòŠËL4åJó…3f5Å8¯]¶e¨}â]Ä·å$!]ZĞ‚İşC=S•WÅcšò¼¾?äÿ³¯‘Ù¬9…fØz0Ş¾•ùIZêpt_¦d/iLªî[·STÀì#Åùø¦DÆ ^~›Ni¼ó#öaL$öAšŠŸi©}5°+š }ÇÕÕ‰Ì¬iæ }Ä-µï+÷•!Ò1eØ¼†vQÛûµ³œ-1
øÆAÄÑüK÷g—»KtW"—#hçzÆï@29øÌp'†å2·É/–Á¯á!Ôtuv©d¥ç7Li¤Äß0µ
„ Ûã«?$V_†U‹İO'8fR!T¡“; Ğa8ª$¬îõ¢5©Î
¦¸ïÖí'›hoƒÉ¬JÏØ€~Û¤Â˜€ÂYõæ’·)VF‘ƒy[´í*À3rÇÆV6Àù¼%Ø	m¡öÖ	-&º'uêrÖDÙ•ø2">ØÚÄ4MW?ƒS…(ÉÃ_"”0§ÙÛK¬4Œ¯%ü 
÷Á9Ã–Zb€vlBé® éVÊ‚ñt9qÓÊ¨f1 ìAñ[x›ËJÙåy¡1ìEõ8!ZædÉÏ9eÚ2(ã3M‘kóä†|ë_	Û{cPVä¬æ¡Yy‰l¨#=êy|¥k PLíÒùKİâEÕaC'‘¦µ^WsœË™$ÕóÓ :Â¥#NJi;İ†¢ÓnŒ*êÊw. ˆ¥nÑGµSÚ"½…p›¹=ø u¤Raûµ•§È+W_°;gî/-,¢9úğÊÿñ¬·íWÉ+ûƒ83ÚÍZ`IÃÍwMf/0Úºñ£¼Õ‡Uë>+ã·{Ã¶@®<1ùzmÍÄNœÄi8¿OgÎ$°Ÿaïç‰»Ë ùH.u
RøZ›Øõ™'0Õ²>Ÿaõ8&ÖŞÉªVC#¾ÍÚŒ,×*öJKyª2MÛ8|x]ßâôØ¼SD\1bç4şv8ŞKe=«:±"DGDEü\Æ§ÒĞD”ÇuãBÜt‰ÒÑ)×gãéj!TPC7âÀZÊL¯mbÌ¡ÆÔXêû·¯¡][­÷.0‘XÂ›­åŒT”Çë4e/}¹…è?‚^¼ú Q€®//óÊĞPü£ÉMÀ|Z<7*½1hq9++Š“ŸØ¤â%‰··ƒ+¢èîçW;w²õéeşòø¹½„š¿X w«4d¥Šº“%)÷à@†¦)oâG`R66¡RÆéÇµ¸J{nı¨§
êìdD+»3¯Ï¾§¾åù-*Ò~B	°22eÃö©ííµ&<Á¢²«¥ç½ªğ—%·% I®‘L’#B‹’+¿‘Ä™zî¾š§Gü¥âmÌ‡GH·ßÁ•èR‰å<»â
~g€8 GàÙŞRf7lÿì±ÈN,vöŠu[ß˜Ç]Ÿş áĞ™åm«í´:8Gó°2JÇ¥ôùˆvşŒ¯Ş’g ×]k!®mñ€6É®#UcÑ@’ÄEsÄH®Š&³•jÍ~1Zè=&LíOH£U÷Óóg9Zs1‚!ñ’#µ/÷Ÿ%)¯l•Z¨Õëª¡Âï´GAŞ›ÚSå}*Æ“Øëz$ÅXŞÀ…Íóç «—6ÕVÍÿhü7ÖÆ°©VjÙ‡ã´œş“Ql‘<>ÊõæÈ†j›ızĞ³_ë5@Ñı‘nl“_E÷¸);gÂ¦/2óÔkY2Ç|ê2³Î‰e²Š;·¹ß'™&q‡“,ğÎWUaĞÔ²¯0ø‘Uø½ªÈìƒŞrÚ”>™Ö
õ ‡+Pÿ#§ğv³^7Î}qİèÓGXÑ£ÍµS›¸/ÜÜpŞ–E(¢7=áH™1n5riŒl ³‡Š€[ w=ÓFŠ.M-ÿï¹ ˆ0H™EÌºm-†S(ğ
kó|]Yòe0mÙIyB0‡Å¨0!-ıÏZ0£FƒL†â÷ô=ğqõbˆêŒH;ÊWùé|ôáî‚3C…æalïÃƒ‹¿.É/;nñÅ“Ãçu‚ƒq¦«HâˆÒ†=£y|| ÷$TÙíARµ?B±‚?ö6şş°šù¡&Í$lZ˜-ÈÃmZNºm§<(
½°J«¼G˜ü<‡6ßtÆ©ë,QáãÑÇgíÏÖÅWØiê#3§3ÍZ§<×Õ;0èÃ*ü?ˆ&Öò£Æ2Ù˜+ï[¼ı¾Ò¬²Ã}"ìÁC3(@²êmrº%h“_voöØT~Š9GÑ^Ï°­áØo”ò ñûÿùëMgk‰áĞÏÅ“@Fß1GMøŠ;åQÇd…±—¶œš#Y@u»®¶´øHÏÀ2„fÎı¿Û´7ó¡çÍÔ:VÑùªo˜QĞ1»dg½¹]Ş?<$BC‰M¯tt²»,šhıc¶©•X/¾çF¸éù"š¸Ùşİ’j,Ër“ë!æGûtÖÄƒu_MÓ¨Î.9N¼¢±Ø ÃLàßMÊa›™¼…½OĞÖƒÍÄ’ÜCdWó…r=)k6ñaKı`™üUVşP	Ş¼ø!l“«B :z÷k–Ü×GdÓ¯h,Ï6;áı
ÃyòG©E|¬‚"Wa×òÍá>‰mW,w©³ñûK°µİƒë1i˜y/Å(d&‘§vĞ©Ê?ù?œMaDd8Ì]ÍE@0SÃ¢‚ÖZú	k¯­Ÿş®ÅÊ\aGœ[ºı]Ú·ıŠöŸ{m«&ö‘ò£¯ãÎµ2’»´cFÅÇ@;ÄĞª`¢f('òÚ"êè ª5«¢´rº~W8ÂâšjÏª	}£³ØãÆŠôøj6¥…íK-ÖIÉçvñŒ©1Ìüß¹â-k¯úì3OjÑ´&bİ ¢ÁÔ‘>â=&‰âC Î(6Oåó€ı©E×Û3<5õFA« ²ÜÃ×ÒPÀæY’¦£³ÒH*px¬Î®¹ØûÑ¡ª^ºMN„o0İX‚V‚ÉÂ,xˆÀOyÍaøbÅ¤á>d#îşÉqÃ+»Æÿ"iÅÉ\¥	¸ê>ŠZ	™S(+_?"FæYøŞsö'EKFux?º¼ç7Ê5ÏÊè{ÌŒCæ®oŠ¢[^\;»`›FÎóÂ±2Ğçˆâ#„–Èq¦ÕdU
:"rE¥¼ûî,e9¤ØÇAÚiÙ^ë…:èéÛıQæ>ë
NÏÄIÓ,ÉÑ°[E?&á©9ÿŸ}ÅL>Ô"å:¬ŠvğwÒu(…BÂl>ş
ÊN¯oJ:è®8Rh÷³~¤¹ÿ™qqˆwÖCé„¨la1å‚à<ş4N_âú–$ ÑG"áŞŞuiµ\èæş|eïá‹'*åÓû.¸CÇPÙÍ´ïu<ë[è½ÖÄD³ãk0—(ı„0²’%âÍĞ|&vä-Bm5W€WŠØî6<›t“#€ßØz²ÄŞí#”ÎxÓÏTÄ1Áíø†·¤o`¶Vtk@ØÔFÿä‚£}Å]÷™Ò×¡Ë¦ÁHØd+Ë?NŸMeuÊÊ¦n/§€<¸»’ıoAS0º˜QÁvì¨3…•Ñ°Âœ/ÍİÕà_iJ+ºqÄCcP	¢q,ôãĞÁáÉ=QÂâTgÆ*ßğøòÏ©:ZMñô·‡‹'ê“ıáØCbtõyt&ï`æº)¹æ%Ú\ç¹œÌ‰4%@OKö0ÉAÊæ]ø!.&h‹Ù*W*|ÆÃ{¹pÉ •øò«¯ZŒ¸×Rãh±_¿£İèœw”½¥Ì:~¬ËK½èu#Ù.Ù×œ‹¯ãb£ıh$CxÀ× 69ósXB“øŠ1	¼P‘Ë>êi½|Ÿö1—Tãğ3†ÅÕÖƒ•.JÀŸ}2UÚ÷«Tårm àÑJ’2Àş?¼6•âv‘ædÿÓÜ„İº{T£¥•dÔhG)·€¬·Îb©QDR¾À>êt	Ë\†)A­“Œ—õÀ¿ ¨½âSDí:a£Me”û,>•âĞb?0Â:^K7‘uû9î‘V<ƒ’‡J3Bœ'çİêÈ-g‘ À÷á€d8KêR€ÄB#{gşkqì¬‘r”©ªëõÊ£{Œ›n|Ï Lh3G†ë!·L;ÚÂ¤F7
æ¸à p&¬±Twl#c„.(vÂÚ¼½Ù”	§Äš5«äÕXv>Ñû	ÚÒ@âNÜmŸßwkîÜ	a ¾¸ÑüÊØ‘éh©üKµÌÙ C#“^Ó’ÎK„ÃÄÃ¹ „m–»s|áÄÎX«hÔÈ¸º¸³\vàŒç¬0êrhŠ×í$°¼'8ÄÈøy3hì¬pÀ™½,•>2Åæ5€^¬&ŞM7î"é>‰ 
…ÀT¬˜[¹£%[ñ‰´K6Tñ$íÅÑ`ğ8zpÍ§‰,Zh,½UpğqlkêšÒ{‚ÖØ¶ìŞà2|æ«Ü}¼6R^Ë“[‰Ff»oÑg\ifâGªw“0¸.eÔŒ¸/~¥píù^	¢™İä«S ú<7ÈO#Ï!†íÃ±6/%8'EµEÏÂû´Olx óÎÉd¸ø·iÅ`ïšûßÚÈ³_ªY+¦Q®áíf5™£›£4ç/Ã‰ âõ"}* ã‰í¯vy„;¸Y.Å”ıj´S=µùcÛ.Â`ï^•H%¤…/iû”|Ma;Óaà ÑİíuØ@¡«Ğú[¿åBxÒZ0™ © :]xPì5âk~Uşí¾©±e$èZìÛ2l´*÷6i2	câÅ–HÓÜ5Å+n &÷%'’=É"@A<V|Sùø¥1O>zOzd¥S5c	»ep°­?ãø¤°2`šç¼{«ˆÉŠYœìo  =QÿèA­'*¬ƒHÕÜnãBJŠQ *íŒyjYJÚ§?_§ÃcQÊœ¾kîé×UtË°Ár¤áİOºÀ-Åk1ÊªÓ&eĞ©h %§Å@£ŠFV²xÊãj~< ]8Ù…O
<Â~.»Qugƒ3dÔ*AJLˆD<ŸüôİÚdylÁ]ÔÅËæLİQŒ°èV³0ñ'¤Â:–ğ_¹#k¨Ö¶Ò3P4•N]n7–-ía¬Mcéù*P©*ãú°Pç¢cXJN)Ÿçî(öˆ¤ímÆ¼Ó2@J;^‘1Äàä4°&ı©ÔÖBMgÁ¬à¥1öAgfz¹ÂUùx?·±S©­€‰jI¯÷~~S¥V]äù§jtDWlÌã2Ìe/g]ªXÄéÔ.Æî°9‚b—Vô p[âu&Ÿ”Æüò¾ÇÀĞ˜‚ä6üŞß9oL¦;œ½`ÛfH^@Ë…X~¼),iqŒKÌã•$5#”.±$–£…µLö™Ë1"Î:SSgK¼¿È"›=",å«>]h“Ú¡‚»U’R1‹À}.®ã_u’<ğª+¢/-d”Z/QŠ½Whµ¸	ÌïzqR¥H“/\#ıeW¨FHøĞan¯›â|¨Ô9Üqó§³¢ríŒ*ùpyßo¬úÀN3£§×b?*GÁˆ6î+‡$bpèæ/%Ä„< ¨tâÃßvÎöû3íœÊ%ef‡½›MÍ¨èzJÕ•x€2V)¤Pïs¨Û6×÷dÖ~ÑéCğ¬ŸmMÓG63ÃŒnh{’‡Qv¼Ÿ˜"¯_ÅiW¿nyåAwÛ–‰£-%sQ›í97½g/J·ˆÇŒó)x,L„5º|Â
ªO2×@£'=µ¯¥®İîZ­Ùê*Í—v³{mWôÌÊõhËÉ ­›ñ§¯aÃ.Øs[}~½¾4<Øø9¹á>I ÙÈ!ÀT€Äš|QtlÛ¹>ˆr@MIÉÏššöÛYØ6oàél£İªB…JÈ—aŞG÷ıÕšäY_Ó‚ÛÉ\ø$è#…æâ35Âl–3ê9%
%‰™c‚J°d_²p7ğN]ØËÃ•ÜKÎ<k¸TÖ4Rz-rŸ] ò|•Š§9mÌ¾4DãOgÉp*¾ú,ox.ãÜ²b á…j‡¹î'nÜÒ¼zc¨ŸwMñöM©‰ LÉH0=¶ÁĞ´Ï¯¼£ô0ğ	úÚşí¶ĞLi+ïÆò»ßĞO¯–£Æî˜9Zds©T˜[TC_Á²^„’áLüu0Nç2Á™ı˜ÜV,aÜ"W´´Ò\ğ[9vğ‹áwİÜé*¡®ÃÜp³å•é¼L˜Me©^¢±ÄIìï‚R°JíZõ5 ÿ‰€rõ³:±Ûd¬D=‚…u2W§ôQ3Ç¡åÔká¡©êùS[t~JÅ\F=»¶ëWôûİŞ<8²T	æ ˜ie‰AF©6Ô"õ;
Ù°…j˜JÄuº¶T[Ÿ!÷×\pÎ¾c.mµ©éHásî4pÂ, Ui¸é€9Ï˜l»ºVS½¨Cú'O‹Ö¿7òµ‹R4hÔ«Ş¼¾öy<q‹³÷*VŞ§Ívd­²ª[Ş¼WÄ&©Ş]‘$ğzEµ±õÜÆs´×“ì	^†=Ø{—È£â3À¥Œ!^™Œ5Lª"[PâÆl£+ÆàòcÅ¥3ı{-ŞÉm/{»µ½W¨#Ó ÅcVºç¸ä¨æx$}Ì÷e±i–O¡*‹IìøºW%œ¶şıÂ0 é8ŞCÿg§±¶œæêjD·š´…+aÛÒ5²Ávk%Wo¹¯°Xõö¤.'ç=)Í*/”|jg”É?¾¦A,
K Zİæbğ!Ïàî¹[â˜…Uê4’§Ú—+¦Hñ_inúhL£ˆ•¬ÌOÒ[ÑKû^´\‘>ØøF§:^’‚Hq?€}ì#ÇÙt¨£GÅÃg°YšUÖ3š¬~<Y'®Ü¨x:Jhÿ0[}ó#¶™Z†ŒçÔˆP\Ş 1×ôU§´zegæe¹…×]½õ—µµ­3
ıs(M8†çlúÉ.FÄ!¸kÍnŠÖLrn0ã2}Àˆ~•ò
ˆŠZ±7Mèƒd@RûH&’½#6ìš2álq¢·zâÄ¶-æ—’é4Ù¼Pp2ãËUÃ5×®ø‚ßgRdisŠ=i<ìİ®ÜÔÈ]/GP³×ÒÁY›f²¡,e•U×¸ £eÙiiòLI¢FÔ0ábĞÙà¼>x!!7‹€¦ë¿òÿrESÉ	A.›¡”7;
şGĞmPÎĞ\:ü~\év¢b"ÔJÉÕ=šªĞ¹iMNÕà:BÄƒt¬™+Ü)˜A]²µaÔÍDaüâ®ŒÃô.[´mË ¸Œ–’f=+†bw}OÇr¨çx·ˆ®!&ãwÏ°¨òİšÚ›‘ïòÁ¼†ã Â\J¥Ø2}JpÃ–^`ÅG°Ë·Ú°B‘) 'OÔzÆõÏÑÂ™Ç½ë<Ü¥ÊL:IÎ†ş£g:œ˜·÷È;“Ùd»yşIƒµÙËŒMj–«¿õ“§°p.íW×%I Š,ƒIæ\d¨++ eàDÔ3V[ö4É 'S—ÿÍ¬SæÇ!c	=Ó¦¾“×	‘3‘°é3 §Ş$Æó£zGÜ'Ïxãİü¬6¬¨kÎ¸)`ŞZ- ¡(j ˜VRÿ. Ûêâv›ô—…À!Êßfñu9Ë‡Bº|ÛÕ}]ô?ŞhS\öËWÖì \OùL>AÛCÊì6ã'¨„g@·Üßº:	œSXÖç±éˆ@‹ğı”D
Õ¸]Rr/C¦Ìjû+¬Áj(²BŠÎÓh•v7×ˆì,;şûy}ójí=­””ËÃæ©w“sqg¬ûE¦ÄÀØD^CùSMH
-R-Ş&®1KCb|¶nrúå²<™R”#¡LlR
a8 ">ÒdõÜx•øë O0'NálñÊcÅ®¢mQ•!"¤’q°ïU¡å$÷W.]Ì¿¾¦~R£ôÏ¸€ËÇ˜ù‰‚ó›Gö[$fF¾‹Y:#¸±/ÓíäËw—ÛÒ™ÄEİn;æÂi6g_äµ®PFR›ı6(
~}Ö³ì{h“¡8*ë¡ÑÍo9äÍelaÔ~$tÂo<€Sh£°–DÇ4ºôßå’=®›eÃşÕ*4}g!ˆÒëğª\»îÁ…hŸ‘¡İW›×¢jÄ¦O}¿[©‰‰'\¼³ÀˆöJò½®gæ„y¤®ªà¬Ï.QºW³ëşG“…ş°;Ê~æ‚	»­:”¾=ü,û$ªÆ3™ÑÌçÁ¬ãòW-Æ*øiäÈvò·™=ÿ»ıÖŠ‹AÏXxîgà4x…ÍÔ]Ò×MÙ×hQî·È¿úÔ™V•ÏE“€"s¶nVG-õ P5&œ£$òiGœè†úCmºc[k4$üf0çõš©6áJÉ£—\¶éYœjR†çÎÚ€o…R½Ù¤£øŸê¦­tŸBŒH$L3pù0˜¨g…uD¯Y7É4 ªAØîü¼Ö0M©ÜU¼ùÛ®n}$Å;Õ76§Û#k|ıwn%g9“ŒÈæÉ¡XÓ ¯øyğ¿ó$µFÕL	¾¨ÔÛˆ7.Öwğøl'Ùq8:Q7·0”f(+Ÿ´òÎï?t¥>ù€¬TÏ#'-­cI¨§qÑE›1ÕWGş’ßÏ'Zº2µØ‡ëßxı¿«¼Ì€¬½:U0ëüûåvœDçÆ$i_vEXT = (glGetPointeri_vEXTPROC)((intptr_t)function_pointer);
	GLvoid * __result;
	glGetPointeri_vEXT(pname, index, &__result);
	return safeNewBuffer(env, __result, result_size);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedProgramStringEXT(JNIEnv *env, jclass clazz, jint program, jint target, jint format, jint len, jlong string, jlong function_pointer) {
	const GLvoid *string_address = (const GLvoid *)(intptr_t)string;
	glNamedProgramStringEXTPROC glNamedProgramStringEXT = (glNamedProgramStringEXTPROC)((intptr_t)function_pointer);
	glNamedProgramStringEXT(program, target, format, len, string_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedProgramLocalParameter4dEXT(JNIEnv *env, jclass clazz, jint program, jint target, jint index, jdouble x, jdouble y, jdouble z, jdouble w, jlong function_pointer) {
	glNamedProgramLocalParameter4dEXTPROC glNamedProgramLocalParameter4dEXT = (glNamedProgramLocalParameter4dEXTPROC)((intptr_t)function_pointer);
	glNamedProgramLocalParameter4dEXT(program, target, index, x, y, z, w);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedProgramLocalParameter4dvEXT(JNIEnv *env, jclass clazz, jint program, jint target, jint index, jlong params, jlong function_pointer) {
	const GLdouble *params_address = (const GLdouble *)(intptr_t)params;
	glNamedProgramLocalParameter4dvEXTPROC glNamedProgramLocalParameter4dvEXT = (glNamedProgramLocalParameter4dvEXTPROC)((intptr_t)function_pointer);
	glNamedProgramLocalParameter4dvEXT(program, target, index, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedProgramLocalParameter4fEXT(JNIEnv *env, jclass clazz, jint program, jint target, jint index, jfloat x, jfloat y, jfloat z, jfloat w, jlong function_pointer) {
	glNamedProgramLocalParameter4fEXTPROC glNamedProgramLocalParameter4fEXT = (glNamedProgramLocalParameter4fEXTPROC)((intptr_t)function_pointer);
	glNamedProgramLocalParameter4fEXT(program, target, index, x, y, z, w);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedProgramLocalParameter4fvEXT(JNIEnv *env, jclass clazz, jint program, jint target, jint index, jlong params, jlong function_pointer) {
	const GLfloat *params_address = (const GLfloat *)(intptr_t)params;
	glNamedProgramLocalParameter4fvEXTPROC glNamedProgramLocalParameter4fvEXT = (glNamedProgramLocalParameter4fvEXTPROC)((intptr_t)function_pointer);
	glNamedProgramLocalParameter4fvEXT(program, target, index, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetNamedProgramLocalParameterdvEXT(JNIEnv *env, jclass clazz, jint program, jint target, jint index, jlong params, jlong function_pointer) {
	GLdouble *params_address = (GLdouble *)(intptr_t)params;
	glGetNamedProgramLocalParameterdvEXTPROC glGetNamedProgramLocalParameterdvEXT = (glGetNamedProgramLocalParameterdvEXTPROC)((intptr_t)function_pointer);
	glGetNamedProgramLocalParameterdvEXT(program, target, index, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetNamedProgramLocalParameterfvEXT(JNIEnv *env, jclass clazz, jint program, jint target, jint index, jlong params, jlong function_pointer) {
	GLfloat *params_address = (GLfloat *)(intptr_t)params;
	glGetNamedProgramLocalParameterfvEXTPROC glGetNamedProgramLocalParameterfvEXT = (glGetNamedProgramLocalParameterfvEXTPROC)((intptr_t)function_pointer);
	glGetNamedProgramLocalParameterfvEXT(program, target, index, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetNamedProgramivEXT(JNIEnv *env, jclass clazz, jint program, jint target, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetNamedProgramivEXTPROC glGetNamedProgramivEXT = (glGetNamedProgramivEXTPROC)((intptr_t)function_pointer);
	glGetNamedProgramivEXT(program, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetNamedProgramStringEXT(JNIEnv *env, jclass clazz, jint program, jint target, jint pname, jlong string, jlong function_pointer) {
	GLvoid *string_address = (GLvoid *)(intptr_t)string;
	glGetNamedProgramStringEXTPROC glGetNamedProgramStringEXT = (glGetNamedProgramStringEXTPROC)((intptr_t)function_pointer);
	glGetNamedProgramStringEXT(program, target, pname, string_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedTextureImage3DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint height, jint depth, jint border, jint imageSize, jlong data, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)data;
	glCompressedTextureImage3DEXTPROC glCompressedTextureImage3DEXT = (glCompressedTextureImage3DEXTPROC)((intptr_t)function_pointer);
	glCompressedTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedTextureImage3DEXTBO(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint height, jint depth, jint border, jint imageSize, jlong data_buffer_offset, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)offsetToPointer(data_buffer_offset);
	glCompressedTextureImage3DEXTPROC glCompressedTextureImage3DEXT = (glCompressedTextureImage3DEXTPROC)((intptr_t)function_pointer);
	glCompressedTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedTextureImage2DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint height, jint border, jint imageSize, jlong data, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)data;
	glCompressedTextureImage2DEXTPROC glCompressedTextureImage2DEXT = (glCompressedTextureImage2DEXTPROC)((intptr_t)function_pointer);
	glCompressedTextureImage2DEXT(texture, target, level, internalformat, width, height, border, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedTextureImage2DEXTBO(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint height, jint border, jint imageSize, jlong data_buffer_offset, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)offsetToPointer(data_buffer_offset);
	glCompressedTextureImage2DEXTPROC glCompressedTextureImage2DEXT = (glCompressedTextureImage2DEXTPROC)((intptr_t)function_pointer);
	glCompressedTextureImage2DEXT(texture, target, level, internalformat, width, height, border, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedTextureImage1DEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint border, jint imageSize, jlong data, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)data;
	glCompressedTextureImage1DEXTPROC glCompressedTextureImage1DEXT = (glCompressedTextureImage1DEXTPROC)((intptr_t)function_pointer);
	glCompressedTextureImage1DEXT(texture, target, level, internalformat, width, border, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedTextureImage1DEXTBO(JNIEnv *env, jclass clazz, jint texture, jint target, jint level, jint internalformat, jint width, jint border, jint imageSize, jlong data_buffer_offset, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)offsetToPointer(data_buffer_offset);
	glCompressedTextureImage1DEXTPROC glCompressedTextureImage1DEXT = (glCompressedTextureImage1DEXTPROC)((intptr_t)function_pointer);
	glCompressedTextureImage1DEXT(texture, target, level, internalformat, width, boó<æò£¾É¾Œcí›´|Aº>	¸©C$Y€Óê(Æf—¢w¦¥ÜRmƒ0Ğu"Ku_»'¼ĞŞ1°½B}9²ÃGü#$è¢Lƒİ"s£¼n‘Pâğ)ÍHšë³æÉiibÏ!\ÆŞ5ÅÈ‹¥ìlXù)ŞÚrS@“×gÈëÇßÌİƒ5¦9ê¦ €gHßİ%XL»ĞŠÑéQÈCXsü…Œ8Kã;‡b®XÜ×j7Få3"ö˜*I]¤!•?¥æß¨À¨]&üF¢&‹ë\Ué‹˜šş2ööƒQÃ9-]%İÚÏãâB	w>ß…/„ÒÃÖIÈšª–S¿A]6Ìqœ9R)Ä¥…JÃÈT‰1òNš –gÈbˆ¸ËäÅ§İÿLûÔBÕyøf‘+ _Š";9iÚcŞæ£#(w¸.XkU€{İcIo „rÂ(¯…ÌŠFÓéÇUÎ…ÎSJŒ–À‹o$ÓÉC³×¨·}0@e¯K†1Ù€9fAÎeºy	ä†Ì“‘Ip}ÏñÅ5|k¯ê{®JmfC½6Ş¶–%é=Í%j@Çİ@w¥V°ô 	Ìé9şc›Õ•IMşâë‚ƒ™}…X€„ÕÄ9“çãtÎcÔQº	,W	=rO¦ô»©Åhé*œ¹ÑwéùäİçY}5àjÊñOQ8/áË'íÚD-YÂÍPmÍv€Üæ„XuÄ€àT˜·0
0id¼áÀ¼şu1M¢Bx}PÜÖ¢8£«ë^!'¼ùišğP¹ä}ÈÍ`šè$÷À¢ØÑ}Nïşµt¦	ŠıBéÛZ­¹—qÖïqß—‰ˆ<¸@ºìÊ›ßÓä~2?ÜO‡†dP.¾’s_”è*ÚÙ'ËOS—Ô¨ÈâY@›2ú°E[Ç8lX.y¨=P¤!X½ÂÊÓ½•QLÁÚÊÊ5Toèd.‰{'N y´—QoÜl,¡tâgn½!8^şú,hÀªAf#_uL?(Ş+=™BÀuÄÂ˜ÃŞÛ)—;)îã÷_µP?É^Ş)ÖPğú'å^ËCx‰G÷ı§´W3«gT¢j”[À\S¥oêü[¡õÿÚY¥ ïØÏã¦¹™ ‘z#z,.ídéè+ôıË7}¨ùÒB÷/~y{Ü‰cú5H¹yKÌë±ÇÓÕmÚÕİ`DµBÜ]½)^(¶Hsq&µÏ¡ÎS
Ïé,YS
–x}°‘JA®¹í.rÇ.Âq{ÿySZ›'[HˆúO¦kr4à}@axîĞp>F9Jö–Ù3¬#vÈÄy7¡¢öµŠä~¢Lh«­(¿@é1÷ŠcÊ(ÍR‰náø»Eªï§$x@À–F–Œgg«ş"¼J—êZ;Páç`ğä¤ğ~ƒ´bJİ×ôh&Œ2uÒ|Ö²sÚ)×'$áæ¢Øå êİõßŸ©n ‚0˜'Õ´3YM÷d±%‘ÆDÛ†‡Âll”rlJ•„Éïì}QÎL¸”	|ç8Mõ3õ©)ê=7§,“‚«Bİ=U«o<â‘S§Â°şòSñøëLÉNõTÖû4Í“ç ›!ÔIÂ·Ï/“¤ãê¿¤ì9ğƒsYV[ÜŞ$C@©aGºW Œ™˜H1f‰Ï©Îq£­ÔÎŸŸ y™Kr)Ã‰›(İ™Û¦ª
˜	m*„`ø}—W—5_'Çå[‡‡Îı"ş:î¹†x¡€'³‘0Œ~äC,ËJÎ¿Ò(ÿø[„GDhka2tvÑÈùçX}NŠWğw^ ·ÊTkÔu¿š/Çö
KÔcàèU	ïëo%‡17˜_ö¡_›cÀ;²íµĞy…ê¨ıAZ…£…G‘é13ûˆïW÷bÎwwB_òkwº½ä÷íh{$àCHÌ
¤qü^…HPÈ÷zMú®uuh`¤¦7çÄ’æ+{jwnÈò!òRÍ¥A\Õòa—~ÏÜU>ó0öİ…®)ŒœŞºÜĞ¢ó°;ŞÇxL‚ƒCX’È	éîl½ZÅQ—ô¶çá0½²bƒpÊºlC<ÜÕLµP,¡ÆâÛ|9'1E¾Ät†JXıá´³ì·Ç›Š,ävSf7ö‡^c’ûùusn*C¯:’Â5ÓØ q–ã’@MÑÎÇÇ¬PäõÈOÎ@9öf97{èøÅàÇ?ŸàmHşõ«Ş;ïVyG@oƒ¾æé•”úŸMÀÉ6«6.UJ)qÏ$ô!™WÜ)ĞÖ“@Zy	£|×ÄdRL\Ú#X
ÿ¡rÕ4b•ãÃ%Ú7i…t¾C)ëŞ¯Ü’ÊõiN¨Q!Ç
KÏ÷b~_âÌ#ş¶÷`¼¡•*7è™ò¡u™p….¶‰iÃÉ¡kG‡:æC“=ì>™¸~d99'ÃD$sV ŒÓjG­»ÂÿÃ¥S¶¤BTUküêèpË‘º?ªòú&yî”p3ïl¨â[ÕOM"‡îûü=·ç]ŞE:Ih:ˆÇñvW9Û×W-ø¹!ãqlq°0ÜQH˜ê¶i	8”tgÒÑAw¹MšK2è)ÏcNæñŒ+qO f„şëEiD·ÖkŸ÷Ü©–o/-^®é †×ü;Iİ¤¢ÜÇø,4e)33NJKqÛ.<rc¹éÍŸ¯¿’L1†÷ºìQóÛz^MfSã0¢®¹£S bã]¬:l uíF‡*•}ıc[îG±’%p»™ãTe!ajşu2ÙõUÈV_‚eÈ¿±jàŒø¶®­Âéf`Kæä›¹N·ÒÜdíÁˆƒCŞ.ºÒS`I2‹µ“*ËÓX¾NDòÂ_•FÖè@æß@™ÃÀENZÓĞEü(Ã|Ö÷}òw n«ç¯£|)eçŠÎığ®/bí{¥0ıDÕ†V)gé~óãx	\CH/uß)ŠÓ	şœ]AJÿUÏdü.C¦bdJù¥C°ÉğŞìÙ¸—@%¯yôè¹lZŸ\…³şúÇÅÔ^ÎñFF¯ÙÀ(ÖÛà˜¸“à¬dñÜkÁ°Të5K·ˆè¾é&’’)B½ÈËúÃY¯(ô%ŒnXÃÔ/5ˆ	½[FMO¿~=QXq»òçéíâÎ¼_{Éİæl¨ûu–,;0Š'Ëwï¼p´ÃËÌğL<¼J]1-@s#¡:ÒUp.»Q†ÚâG3eHÏĞÀÛ:ìÄUı$B5­&ÉH<ëÚcãà¯SöE’.¢µ¡ù}o1Õ>¹p^X"*Ï;Ğ“Â\¨ÛG­#Sõ—Ö¸uJFâñî%Ádœq2¦ü‘ê¯HøÁaA |[ÒhïËvÆ…!‰&äúåX‡ÑªT>°IÓâ–Ñ0.³€³7A£$Y˜œÚ£ËÄñò¡œê:Õ:—ey GTAbÔ¶'~ß¿$»Ûßv¿dØmÜ¯šÒw>JnW`•6^Wş¶3/ŠbH¾ÉPHKq¦0D±Å¤Ù:|4“FÊg¾É­,z9é³£^¿¹_.6Øš&ÒÒ¿ñø¥ôİ¨kH>’†L!G$ÎIßŸåIYÀâØ“ØÀ·ÚA'bd2Y	è¾£aáøÇî#¼Û«TÖÂšÇÊ{®|^ó…µ€ 0­ã VŒ-SÌ‡4¥…¶,ƒQCK¯g½
hs ”CÌ'¬Ot¡ÙaİWı¸[Jù–Ó7x©Rv:Üğâ˜ˆ87Ò°æzêI£¦ü 'gêóâªucÏ{nMíëÖÇ‘eÎº(	•şØ;£lÚ¨u-°Ô^`s
m®, ëÎ°½¡0$¥÷9ªî‰ˆZåÅ’Ç½l)l>š=$_‘ÿäJÈ«ıe¡!Q'Û5}œÿ‹[yç4íFğjEMò==!Ì+zÁ5ª„üF¾¦oeš£Å’g‹0ı¥Õ+cä HB<0•‹p&¢Ü” S œè£ZøÚ´°øÆ…Bàµ,H×·|ÎdÎFüÔ‹ã’*Ï§ŠÂ¡ñ	eûú‘àª%’°-ë™Ÿ ˆª€ş›‘w@„¢"Ù;ˆ£,ÂõØVôMòië³•‰ØuCVÓZrğ™x+hr[ÇÃã X‹z7I8vÙÉ‰÷u×ô²½ƒQéŸ*…İ]¢ïŞbø¾L•ßq}IW¤ë¥AvRô·¯ú…‘îğ¦,*êOşY’G±—4îÇÕgB”ä0¤P¸srL‹X|ß, YÉ	ÜH,KUä‡øûÓxGU* ˜íI_YŸ«9TdS¨X‘XĞ“â"äŠad)K21tı9úx§æGß+^=fEÛíÎh_Yú3{yé Ìæd"Î¢ÉêœÑ­H=ŸN8‘ß÷Ò“Bu?ŸÁİ+‹N¦©ïà¿N$±u2¸£==N9/~;?ÙĞ¶z+¡˜NÊNDhqİä‰aŞÑv	Àİ-Vt¼lX¿Ì†¯ÃßN(ˆşï4€ÓòP¤<cHnkS£ùí´)*˜ğãj¦aÏÅL5ä˜5ŸíŸ&z'O&‚¾–:ââd´B{»Î—•ÌT¯ñ‹P±EÎÄÊ¥İ=TÓKƒ<ÓÔE1¢¿©ÛÃ…|Q%±Ïš<CÂ?gı·JGş™pÎC›øÛ†»5üRÔ´|k¨c#ÜÆ]bƒì<-SôÌb‹Èâ1ív£“^ı(JV5µY_¤éš°VxáLB—û^›¬åÿ<!ÍÊÉ‹nÈûçZ¦X'Ú5ÔãP¨ôˆI‹~Ö/ŒËöÕV«ıÄ·à§ÓñàQ¼fín_ä²'(5Hä‘‡m‰Á;8qúÔ0ÌÃ~¡ıÊ_ÉwÌTµ\XÑÌêàvÅqÀ›¯*’³Vy¿!ìı[âî^l~\·¿™û`ÖJ8*àPú•½,ÉÖ£úÅÑÇ£Ó…¿_‚‡µ 3Ç`•“¦“R¥ò‡‹·xo:Ío§h^d+HÕø‹òVn¶«A_LíHğív+|é d‡¹—5>Òı§Jnò3·EÁÔ	ŞUJå(t¬¡e³“!"Ø¯¿IH»reû}G&Ót&¦¢#*›³¸z½Åß.?WäÍÅwD¹2˜XÎ2‚À“ùÛœ73şD7NñE‘¤±ıò> ¶$ªˆ]Ü'Ù
Ç©ı¿¨¼+¹«L}Šdì§;u'\îğ	Ä*˜l³§ˆhXë+Ò²×­ÀFw•µĞœ¾í\ÓãC—úºÂAƒãwÁC]ö®í6èèp4¨ªA&¿,oò»Şj»âoViÎ¶Væº!‰äuˆ$°D¾/²guÄ–Sk‰O•†¶Î™d–ä*ŸÆ¾Q—Ëj·¦© ~k­iãE(Šfn(Ÿ×Í“¯_hşàIp„ {ÿ1£Yü0.–ˆï;÷±íˆÇ°‡Dá“R¸'(ÑC/«¾H)OÅŠğlš4ü»cÎÜ&²&ó'ÓQ6kYV6³!ãëäŞJf?Ö¡dlü+û|İ5x·£µOaŞí.Úu¤şµ÷ép^Qøl¹×>îî‹ósšYï>ïÛ^BM•ÇFØÀãÓÎıè%Ã\mê‹"GRê’bMP¨ÙŞ	ÑZÏIzÔOÉNq0‘ 1ÖB^y¥ ÍÂÌ[7O÷'>ò…ih½ ˆq½æÛäO±êËS$+Mğ#O©%œúÃZä±‰Âó(âõ$‹Dˆ|lØññC	/2ÕÔŒ>Ğ‰ŠŞXÖÓæĞx¦j2Ïk JÏŞk1W™Ìê7½9ª=¦ Ìuè2ÙcÊj˜´¡ÀåŠè“i¶7ÒQçOíqÚT¦D+0FbËr•T¨Ï”>¬>UhLHšAìoCd’_…o¸Ï£÷1FĞêÁúºİ†nÒ‡ÓšGÓÊB„ê7`¢VjOûA¤51šÉ7%†> 7ø“Ä¶É@~uÕäŞL¼ó°qïuj^ºsÎƒ:ø<“`ScLúMuó?r.È(èé7ÿG«Ú]NèãÑ‰±šv”YŞV½ÌÉ™¦âd“5R7ïØ_N"(]dH6Ê×£ºÒuøxÓƒÉaåüçÊ±nKM‰°ù@nì…y´†_ ĞÊazp‰ÔÊ‘CHÅ¤êOßøXrh@Œ äÔ¿ètFAsl‚ˆİSªÍ\0W—ÑA¼½W¯ùméÚ8Ïî ÌÊ¦Ë˜zŞØ‚WÉ	•ş<AîıAìéœ{Ã›ùpÿŞÑ†&¬Cª²ùŞíâÔ++>7ÓF©„xgmó…fX¡nèÓ-Ò[X:“Ø®ÊÂR}±™sıÏ	yL>y7¯gRÇHQsØ¡Ÿéœµz`ôç±¥!I2aà³q.r<…Bj×f&²^ğDd°2kÃÀcpú—"¿,M8fH`m,,—J2ŸQÖj·Œ–Â6î×=,?îõº0wo¼(G¡)7ŞïgÚ›7€pğh9p‰G÷ûˆ Ø]«*+§{ŸeÄW›zàµĞV¤°Ä‡úx´şÉ°·»²¬Q·•{`gbÄbêìJ"âøË?ıÿÏE×j~#r|È‰$oŸ&‡{æûâˆÂ—;œœÙw©WšM´<]nÿŠU=ro¥Ş±—	Ò«xHXXÑdhîYWúóà%vCÃg”~~½-S\[N/AÍâ@¾-t+æl?(t¬„:%@3G·ˆÑ$%ù-œcÿ?.‘»úö»ƒûd­@.´ª%¿	ä0ÚiÑj™]’)µ£ß"Âëš>v«úZ•ŠmJg«ş"Ï™âG/§¯.»â¥íUÓœ)yFËİ¦MEë-oÓW‚Ü4zÀ(ƒY/ĞıªNÍä6°ÜçØŞjë3¥‹;™š•\Gê)ª²çJÙ<™ÀA}ÎehZ Ú¼‘hXŞ	C‹hñnmıÍño‰-±Š£Etı7`tº‚J–Èûâãúê2øgÙ#fš>À·í^¯én‘ï‹S‘°Ôğ ±7ü(Ê‹vsFì#Òk[‹C	÷L-§µ¼l7!Q‰ôÉ|£ ¶ÈÊÙ»Ÿ&J–ğ“-ğ‚Ó¤Æôtáen¦“eø]‘PºK,Ö¿K§§Ó¸7ü}ß<!Áx¥Š5¸Œ@<ÀoóT'‚šğØ+úøC„GTiyb3c‘ìúSzIÃ«>M=»’/‘t½›<ƒ¢BÀrøY Fûàx:ÊerÕWü¥k—JÌm÷N¬¥ĞR…Ñ	¾ü@Lßë¡'7–1t¿ƒşBà`ÕU@ù"Y}¹°ìøà}eÜjFá‰z¶úNƒpS"ÂõxuÓ©di8^lµ·çö’Ó-YlaBÕ¶ğÜMÒ°WJÂ¸ãY†oïÌ_Í$óñÛ‹±úØ°¬Îs¡ø—›=‘ÁÑÎöü?­“VV]UŠº¶¢í «¯A'Å9Î§"C}ÚÓ[¦xçæÆ2!b+E¤8À\à¯©_¿æ¿Õ’˜o¶qIÆ`?äÔL~Ú¯û0=pc^ë&Ÿ‡rÑÅBN;—èAÀÂJÌ‚BÙåXÿ§ÆI†|¸xp0b©öÍ+îñzÅï-úşäÔ=»S4sb˜¿ZáØ™†õƒFë•y¨45^_ 7ÁG\“WÜÔ\ø±BPbD£-¾¯P|SÍ3Jz;°õ6	œ?‚e€œåÈ*e’^~¶$ğÀ¨Úï¡¯çgS­Jä+EÍÀ{SN¸Ğ ü‘÷lœ»· ó9íÆ¢qßUŸ/€½§X¼‡Ã„wO™ÕGùcVŞe„$é>¹¾yI26˜TSKmOË>o«0‚âßé• ´¬U^@oûışPÛ—¾'§áö@XÓ…I ÅÅvf›I7´Ù½÷8«áGÔO(Lk'çñ|7o·ºşÃQ´\+Rü×]L˜Ğ‘5—gkPøËiLøW‹Vn¡AéJ]ë ù„//
p—‘ß²	ov´İ rÒ°Àõ´/DqëæŒÊà;UÙ¿¢ÑÇø&>a!>G?MRuÎ9n=ôìØÇî— ’\+Ï¤ö¾o3úúPj1w\rŠH™“¤@+®-t€*D68yvèQ’¥nşXBúÕğ_hØô‚j<`[Ü_ù†WÆ7&r®Uú¬“-Æ®áº°ÕıJiXØæ’T·ïÎjûé·»¢èòB[ ;ƒ?¸€y’éX¯kJîÑI•ĞàléÉQ§ÏÖ![XÎ–t?Áz ã[ñÆ3ğ6xl å¯£ƒizz¢ŸÇğ¦ôi+éfë<²GŞ–Ll3¯7÷­uFNDI-d‡cŒÉG^û_LÎFµVÈ~¨fO¡qiL»äE¿Èö“ëÂæÚ]gû3êï©8[Ş‰ã ÊŒSÊêåÔÀiëÖçš»ÍŸ©kùÛ.ÜñÌYâ	LªÍ¢ëí)‰•!†ÙĞòJ—V±nº‚(YbBÙÏa-´»\şqgh9_ m­õ´œ´‰¶T5œÕ³E¦öuÄcakLÙs“`òwéŒêæúQó0p*Q/5ŸYÓR-FiíYŒÿşO7>Sã1£Óáí9õİsı/x=˜&ƒxÁë`Ä?êâyXĞ»<“–€ÓZ#Õ	¿&eTt<œLî%ñÁšuõI§6Ô¡ı‰1fñæä0<Ş`ˆgY5ŒŠ¥Û8·òØÂtV@gjdàMÓçA†Âg¿8ÿãÿ#^‡ŒÒ0T£Lÿã¤Ñ-"®‡³!%íjZ9«•á…ËÕäòà«ÊÕw›œh~1F({Ô£pN¶ÇC¹Û	‡#´<kÓ¼‘ŒÉÃ:3[4{ĞrRP´ğ(/—) ³ŠLWf¶yêŒ©À37q¨D3öˆ£)À¬©½Z×àKYYù°ıï,¸ÀÓ“Ò˜­wa¿ÆAUm" Jû>®õt‡ËÛŸæ¦ür@O\'}'İ¥¥aãÄ–ãğy;†õ ­@Öé¥ÿÌd»m~÷•´'¡Äˆq†		Y“³˜¢#œ`zrz´"ÄW2a™EUé‡;?‡öRâË·ûPŠU¼„Å5p®OR?Óş¸ÀÉ 9Ù°ê.åS¢T¯µv(b¨§¨·z$Ã”#+…JâóĞŠaÖº(	•şØ4¥nÈá!KÈ)­šBÄnNaä/'ñšò´¼&,¶Æ½:­ôİÁ^éÃñ‡``M8™4E`Zš„ÁªLFÂ¡á]K¼!hè*|’±™Ke­`ÿ$i¦yEJï=\Dš?j8ˆ„:¿ûÚn£ªx6ú„Îe»?ê÷÷f«TJuvÓ‘jr•ä0NMØ£şY›¤Í£æÚÿ¡/HÁ¦LõQÓ]úÔªÀåº3¨Èã¨áœ×XÒª©‰ŠşEèË/ô©•©¬½ ‡øŒ
wƒ}€—?¡¬œĞŒ½&ÇqãIÅã	œ¹Ä}W.VØ]bæ±^2~RbÃÜÏ\¸z¶#^/aĞÜÈşm#Ìëyñ–Wâ˜&6†Ç)y¨ş ÇfíD·ÚBAXwŠ²ÿlOå£í¢‘^úÍ°:,(åwë¿l¦nD°²«W‹½PºeuÏyfÎ)XïÈD.zÙËøö‡MpA]*mÊãAJG §5T$_ìP‹M5Ã™ç<ç–` s2lw”GØÎËzædjÖÙ6Ñ«wx×tTKöö¥6!ğºß*â§Ì¸^ ÏÈw´†¹lª¼oH)³ğæ³£eºÉšN
I`—±89u8a&Üß‚c‡…JÃ}_hqİâ¯;ñüKÚÊyP±yìğ„©Ü3@4›áækÅ÷éHğ!:~tqoæ¢ÀŸ^Ä:ÌÍJ¼;Ï…@5æ”^:Šä’y)mM3Ø¼ÕW6ŠéâhàM`¡‡”ÈÑÍû»–_
öFÕš‡®ŸiÖ@yÖ•<®‚´ÏÇ(^;°€ÄÜ7PÛ?L³âFHõŸÖL™ÿÖŞñ6şIš±3¹h2„Xe²ès-PáÎueÂÉŠ§äu¢€^ŞHqÿT«úÛ‰BræJN‹æ!Öã¤ò'*Ì—É·/´íQèzÒöáOµâ÷ÆpÄˆÛÆÈc±³ò_«¬Ü—äŸt%¬jû«V¨'qz7±ìÉe«ŠDWóóÄËx ëüN4½~Üyı ‰Pmäûİ|…Iıbı¹œx¬5\p›6ëûLãğ^bCX‚½„ƒIòu	;™5Š¦ñR†“´äãÍÙ¶Å´©T“–Š°Ækˆ›¿°›†Òf—½”k]¦/á4G
bHÁŠµSo±±w@MÛVëájv"wÊ2áóŸ4Ïõ¤Knå·‘|ßÅ3ÿR{Á$r®õ¿ï}3Ô³³DïgvîVB*Ÿ}5µ«c&Ãµ°h«ÒÅZb.QòÔÌ/Hÿ*ƒQÛ.‚À˜ûÈŸ7»;°F•ƒ¹ØövD  ­š+†N·}¾×ŞÎëÿìñ%”
Ó
AHDô™6'á˜lœ˜ªv{ÕlÇ¿Ö¦øEZ¢¼É‘µŞFäÇbï³şpˆÃRÜTyö˜êã8çT4¯šq%¨2Iî¥Ë|ŠôdGx&	 Æ…VÛ«ÀÉ^t‘1¦PØ/‚MÛHx…ÏE%œÔ–¯Ø}Œª=ÓÓ¡SÏf=Ûı»¥udc‹Oèw¦6Ã|{z”×ÏÚã!úør†M,Ÿ0ó{ [ç~ Øšrnalformat, jint width, jint border, jint imageSize, jlong data_buffer_offset, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)offsetToPointer(data_buffer_offset);
	glCompressedMultiTexImage1DEXTPROC glCompressedMultiTexImage1DEXT = (glCompressedMultiTexImage1DEXTPROC)((intptr_t)function_pointer);
	glCompressedMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedMultiTexSubImage3DEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint yoffset, jint zoffset, jint width, jint height, jint depth, jint format, jint imageSize, jlong data, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)data;
	glCompressedMultiTexSubImage3DEXTPROC glCompressedMultiTexSubImage3DEXT = (glCompressedMultiTexSubImage3DEXTPROC)((intptr_t)function_pointer);
	glCompressedMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedMultiTexSubImage3DEXTBO(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint yoffset, jint zoffset, jint width, jint height, jint depth, jint format, jint imageSize, jlong data_buffer_offset, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)offsetToPointer(data_buffer_offset);
	glCompressedMultiTexSubImage3DEXTPROC glCompressedMultiTexSubImage3DEXT = (glCompressedMultiTexSubImage3DEXTPROC)((intptr_t)function_pointer);
	glCompressedMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedMultiTexSubImage2DEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint yoffset, jint width, jint height, jint format, jint imageSize, jlong data, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)data;
	glCompressedMultiTexSubImage2DEXTPROC glCompressedMultiTexSubImage2DEXT = (glCompressedMultiTexSubImage2DEXTPROC)((intptr_t)function_pointer);
	glCompressedMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedMultiTexSubImage2DEXTBO(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint yoffset, jint width, jint height, jint format, jint imageSize, jlong data_buffer_offset, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)offsetToPointer(data_buffer_offset);
	glCompressedMultiTexSubImage2DEXTPROC glCompressedMultiTexSubImage2DEXT = (glCompressedMultiTexSubImage2DEXTPROC)((intptr_t)function_pointer);
	glCompressedMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedMultiTexSubImage1DEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint width, jint format, jint imageSize, jlong data, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)data;
	glCompressedMultiTexSubImage1DEXTPROC glCompressedMultiTexSubImage1DEXT = (glCompressedMultiTexSubImage1DEXTPROC)((intptr_t)function_pointer);
	glCompressedMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCompressedMultiTexSubImage1DEXTBO(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jint xoffset, jint width, jint format, jint imageSize, jlong data_buffer_offset, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)offsetToPointer(data_buffer_offset);
	glCompressedMultiTexSubImage1DEXTPROC glCompressedMultiTexSubImage1DEXT = (glCompressedMultiTexSubImage1DEXTPROC)((intptr_t)function_pointer);
	glCompressedMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, imageSize, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetCompressedMultiTexImageEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jlong img, jlong function_pointer) {
	GLvoid *img_address = (GLvoid *)(intptr_t)img;
	glGetCompressedMultiTexImageEXTPROC glGetCompressedMultiTexImageEXT = (glGetCompressedMultiTexImageEXTPROC)((intptr_t)function_pointer);
	glGetCompressedMultiTexImageEXT(texunit, target, level, img_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetCompressedMultiTexImageEXTBO(JNIEnv *env, jclass clazz, jint texunit, jint target, jint level, jlong img_buffer_offset, jlong function_pointer) {
	GLvoid *img_address = (GLvoid *)(intptr_t)offsetToPointer(img_buffer_offset);
	glGetCompressedMultiTexImageEXTPROC glGetCompressedMultiTexImageEXT = (glGetCompressedMultiTexImageEXTPROC)((intptr_t)function_pointer);
	glGetCompressedMultiTexImageEXT(texunit, target, level, img_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixLoadTransposefEXT(JNIEnv *env, jclass clazz, jint matrixMode, jlong m, jlong function_pointer) {
	const GLfloat *m_address = (const GLfloat *)(intptr_t)m;
	glMatrixLoadTransposefEXTPROC glMatrixLoadTransposefEXT = (glMatrixLoadTransposefEXTPROC)((intptr_t)function_pointer);
	glMatrixLoadTransposefEXT(matrixMode, m_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixLoadTransposedEXT(JNIEnv *env, jclass clazz, jint matrixMode, jlong m, jlong function_pointer) {
	const GLdouble *m_address = (const GLdouble *)(intptr_t)m;
	glMatrixLoadTransposedEXTPROC glMatrixLoadTransposedEXT = (glMatrixLoadTransposedEXTPROC)((intptr_t)function_pointer);
	glMatrixLoadTransposedEXT(matrixMode, m_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixMultTransposefEXT(JNIEnv *env, jclass clazz, jint matrixMode, jlong m, jlong function_pointer) {
	const GLfloat *m_address = (const GLfloat *)(intptr_t)m;
	glMatrixMultTransposefEXTPROC glMatrixMultTransposefEXT = (glMatrixMultTransposefEXTPROC)((intptr_t)function_pointer);
	glMatrixMultTransposefEXT(matrixMode, m_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMatrixMultTransposedEXT(JNIEnv *env, jclass clazz, jint matrixMode, jlong m, jlong function_pointer) {
	const GLdouble *m_address = (const GLdouble *)(intptr_t)m;
	glMatrixMultTransposedEXTPROC glMatrixMultTransposedEXT = (glMatrixMultTransposedEXTPROC)((intptr_t)function_pointer);
	glMatrixMultTransposedEXT(matrixMode, m_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedBufferDataEXT(JNIEnv *env, jclass clazz, jint buffer, jlong size, jlong data, jint usage, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)data;
	glNamedBufferDataEXTPROC glNamedBufferDataEXT = (glNamedBufferDataEXTPROC)((intptr_t)function_pointer);
	glNamedBufferDataEXT(buffer, size, data_address, usage);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedBufferSubDataEXT(JNIEnv *env, jclass clazz, jint buffer, jlong offset, jlong size, jlong data, jlong function_pointer) {
	const GLvoid *data_address = (const GLvoid *)(intptr_t)data;
	glNamedBufferSubDataEXTPROC glNamedBufferSubDataEXT = (glNamedBufferSubDataEXTPROC)((intptr_t)function_pointer);
	glNamedBufferSubDataEXT(buffer, offset, size, data_address);
}

JNIEXPORT jobject JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMapNamedBufferEXT(JNIEnv *env, jclass clazz, jint buffer, jint access, jlong result_size, jobject old_buffer, jlong function_pointer) {
	glMapNamedBufferEXTPROC glMapNamedBufferEXT = (glMapNamedBufferEXTPROC)((intptr_t)function_pointer);
	GLvoid * __result = glMapNamedBufferEXT(buffer, access);
	return safeNewBufferCached(env, __result, result_size, old_buffer);
}

JNIEXPORT jboolean JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglUnmapNamedBufferEXT(JNIEnv *env, jclass clazz, jint buffer, jlong function_pointer) {
	glUnmapNamedBufferEXTPROC glUnmapNamedBufferEXT = (glUnmapNamedBufferEXTPROC)((intptr_t)function_pointer);
	GLboolean __result = glUnmapNamedBufferEXT(buffer);
	return __result;
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetNamedBufferParameterivEXT(JNIEnv *env, jclass clazz, jint buffer, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetNamedBufferParameterivEXTPROC glGetNamedBufferParameterivEXT = (glGetNamedBufferParameterivEXTPROC)((intptr_t)function_pointer);
	glGetNamedBufferParameterivEXT(buffer, pname, params_address);
}

JNIEXPORT jobject JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetNamedBufferPointervEXT(JNIEnv *env, jclass clazz, jint buffer, jint pname, jlong result_size, jlong function_pointer) {
	glGetNamedBufferPointervEXTPROC glGetNamedBufferPointervEXT = (glGetNamedBufferPointervEXTPROC)((intptr_t)function_pointer);
	GLvoid * __result;
	glGetNamedBufferPointervEXT(buffer, pname, &__result);
	return safeNewBuffer(env, __result, result_size);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetNamedBufferSubDataEXT(JNIEnv *env, jclass clazz, jint buffer, jlong offset, jlong size, jlong data, jlong function_pointer) {
	GLvoid *data_address = (GLvoid *)(intptr_t)data;
	glGetNamedBufferSubDataEXTPROC glGetNamedBufferSubDataEXT = (glGetNamedBufferSubDataEXTPROC)((intptr_t)function_pointer);
	glGetNamedBufferSubDataEXT(buffer, offset, size, data_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform1fEXT(JNIEnv *env, jclass clazz, jint program, jint location, jfloat v0, jlong function_pointer) {
	glProgramUniform1fEXTPROC glProgramUniform1fEXT = (glProgramUniform1fEXTPROC)((intptr_t)function_pointer);
	glProgramUniform1fEXT(program, location, v0);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform2fEXT(JNIEnv *env, jclass clazz, jint program, jint location, jfloat v0, jfloat v1, jlong function_pointer) {
	glProgramUniform2fEXTPROC glProgramUniform2fEXT = (glProgramUniform2fEXTPROC)((intptr_t)function_pointer);
	glProgramUniform2fEXT(program, location, v0, v1);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform3fEXT(JNIEnv *env, jclass clazz, jint program, jint location, jfloat v0, jfloat v1, jfloat v2, jlong function_pointer) {
	glProgramUniform3fEXTPROC glProgramUniform3fEXT = (glProgramUniform3fEXTPROC)((intptr_t)function_pointer);
	glProgramUniform3fEXT(program, location, v0, v1, v2);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform4fEXT(JNIEnv *env, jclass clazz, jint program, jint location, jfloat v0, jfloat v1, jfloat v2, jfloat v3, jlong function_pointer) {
	glProgramUniform4fEXTPROC glProgramUniform4fEXT = (glProgramUniform4fEXTPROC)((intptr_t)function_pointer);
	glProgramUniform4fEXT(program, location, v0, v1, v2, v3);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform1iEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint v0, jlong function_pointer) {
	glProgramUniform1iEXTPROC glProgramUniform1iEXT = (glProgramUniform1iEXTPROC)((intptr_t)function_pointer);
	glProgramUniform1iEXT(program, location, v0);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform2iEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint v0, jint v1, jlong function_pointer) {
	glProgramUniform2iEXTPROC glProgramUniform2iEXT = (glProgramUniform2iEXTPROC)((intptr_t)function_pointer);
	glProgramUniform2iEXT(program, location, v0, v1);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform3iEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint v0, jint v1, jint v2, jlong function_pointer) {
	glProgramUniform3iEXTPROC glProgramUniform3iEXT = (glProgramUniform3iEXTPROC)((intptr_t)function_pointer);
	glProgramUniform3iEXT(program, location, v0, v1, v2);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform4iEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint v0, jint v1, jint v2, jint v3, jlong function_pointer) {
	glProgramUniform4iEXTPROC glProgramUniform4iEXT = (glProgramUniform4iEXTPROC)((intptr_t)function_pointer);
	glProgramUniform4iEXT(program, location, v0, v1, v2, v3);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform1fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniform1fvEXTPROC glProgramUniform1fvEXT = (glProgramUniform1fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniform1fvEXT(program, location, count, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform2fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniform2fvEXTPROC glProgramUniform2fvEXT = (glProgramUniform2fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniform2fvEXT(program, location, count, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform3fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniform3fvEXTPROC glProgramUniform3fvEXT = (glProgramUniform3fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniform3fvEXT(program, location, count, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform4fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniform4fvEXTPROC glProgramUniform4fvEXT = (glProgramUniform4fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniform4fvEXT(program, location, count, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform1ivEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jlong value, jlong function_pointer) {
	const GLint *value_address = (const GLint *)(intptr_t)value;
	glProgramUniform1ivEXTPROC glProgramUniform1ivEXT = (glProgramUniform1ivEXTPROC)((intptr_t)function_pointer);
	glProgramUniform1ivEXT(program, location, count, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform2ivEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jlong value, jlong function_pointer) {
	const GLint *value_address = (const GLint *)(intptr_t)value;
	glProgramUniform2ivEXTPROC glProgramUniform2ivEXT = (glProgramUniform2ivEXTPROC)((intptr_t)function_pointer);
	glProgramUniform2ivEXT(program, location, count, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform3ivEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jlong value, jlong function_pointer) {
	const GLint *value_address = (const GLint *)(intptr_t)value;
	glProgramUniform3ivEXTPROC glProgramUniform3ivEXT = (glProgramUniform3ivEXTPROC)((intptr_t)function_pointer);
	glProgramUniform3ivEXT(program, location, count, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniform4ivEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jlong value, jlong function_pointer) {
	const GLint *value_address = (const GLint *)(intptr_t)value;
	glProgramUniform4ivEXTPROC glProgramUniform4ivEXT = (glProgramUniform4ivEXTPROC)((intptr_t)function_pointer);
	glProgramUniform4ivEXT(program, location, count, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniformMatrix2fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jboolean transpose, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniformMatrix2fvEXTPROC glProgramUniformMatrix2fvEXT = (glProgramUniformMatrix2fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniformMatrix2fvEXT(program, location, count, transpose, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniformMatrix3fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jboolean transpose, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniformMatrix3fvEXTPROC glProgramUniformMatrix3fvEXT = (glProgramUniformMatrix3fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniformMatrix3fvEXT(program, location, count, transpose, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniformMatrix4fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jboolean transpose, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniformMatrix4fvEXTPROC glProgramUniformMatrix4fvEXT = (glProgramUniformMatrix4fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniformMatrix4fvEXT(program, location, count, transpose, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniformMatrix2x3fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jboolean transpose, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniformMatrix2x3fvEXTPROC glProgramUniformMatrix2x3fvEXT = (glProgramUniformMatrix2x3fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniformMatrix2x3fvEXT(program, location, count, transpose, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniformMatrix3x2fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jboolean transpose, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniformMatrix3x2fvEXTPROC glProgramUniformMatrix3x2fvEXT = (glProgramUniformMatrix3x2fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniformMatrix3x2fvEXT(program, location, count, transpose, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniformMatrix2x4fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jboolean transpose, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniformMatrix2x4fvEXTPROC glProgramUniformMatrix2x4fvEXT = (glProgramUniformMatrix2x4fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniformMatrix2x4fvEXT(program, location, count, transpose, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniformMatrix4x2fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jboolean transpose, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniformMatrix4x2fvEXTPROC glProgramUniformMatrix4x2fvEXT = (glProgramUniformMatrix4x2fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniformMatrix4x2fvEXT(program, location, count, transpose, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniformMatrix3x4fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jboolean transpose, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniformMatrix3x4fvEXTPROC glProgramUniformMatrix3x4fvEXT = (glProgramUniformMatrix3x4fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniformMatrix3x4fvEXT(program, location, count, transpose, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglProgramUniformMatrix4x3fvEXT(JNIEnv *env, jclass clazz, jint program, jint location, jint count, jboolean transpose, jlong value, jlong function_pointer) {
	const GLfloat *value_address = (const GLfloat *)(intptr_t)value;
	glProgramUniformMatrix4x3fvEXTPROC glProgramUniformMatrix4x3fvEXT = (glProgramUniformMatrix4x3fvEXTPROC)((intptr_t)function_pointer);
	glProgramUniformMatrix4x3fvEXT(program, location, count, transpose, value_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureBufferEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint internalformat, jint buffer, jlong function_pointer) {
	glTextureBufferEXTPROC glTextureBufferEXT = (glTextureBufferEXTPROC)((intptr_t)function_pointer);
	glTextureBufferEXT(texture, target, internalformat, buffer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexBufferEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint internalformat, jint buffer, jlong function_pointer) {
	glMultiTexBufferEXTPROC glMultiTexBufferEXT = (glMultiTexBufferEXTPROC)((intptr_t)function_pointer);
	glMultiTexBufferEXT(texunit, target, internalformat, buffer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureParameterIivEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint pname, jlong params, jlong function_pointer) {
	const GLint *params_address = (const GLint *)(intptr_t)params;
	glTextureParameterIivEXTPROC glTextureParameterIivEXT = (glTextureParameterIivEXTPROC)((intptr_t)function_pointer);
	glTextureParameterIivEXT(texture, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureParameterIuivEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint pname, jlong params, jlong function_pointer) {
	const GLuint *params_address = (const GLuint *)(intptr_t)params;
	glTextureParameterIuivEXTPROC glTextureParameterIuivEXT = (glTextureParameterIuivEXTPROC)((intptr_t)function_pointer);
	glTextureParameterIuivEXT(texture, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetTextureParameterIivEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetTextureParameterIivEXTPROC glGetTextureParameterIivEXT = (glGetTextureParameterIivEXTPROC)((intptr_t)function_pointer);
	glGetTextureParameterIivEXT(texture, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetTextureParameterIuivEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint pname, jlong params, jlong function_pointer) {
	GLuint *params_address = (GLuint *)(intptr_t)params;
	glGetTextureParameterIuivEXTPROC glGetTextureParameterIuivEXT = (glGetTextureParameterIuivEXTPROC)((intptr_t)function_pointer);
	glGetTextureParameterIuivEXT(texture, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexParameterIivEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jlong params, jlong function_pointer) {
	const GLint *params_address = (const GLint *)(intptr_t)params;
	glMultiTexParameterIivEXTPROC glMultiTexParameterIivEXT = (glMultiTexParameterIivEXTPROC)((intptr_t)function_pointer);
	glMultiTexParameterIivEXT(texunit, target, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexParameterIuivEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint pname, jlong params, jlong function_pointer) {
	const GLuint *params_address = (const GLuint *)(intptr_t)params;
	glMultiTexParameterIuivEXTPROC glMultiTexParameterIuivEXT = (glMultiTexParameterIuivEXTPROC)((intptr_t)function_pointer)X0séöefYéä¯œ¾cñ^ìÛ	K¥&ù­
xB)&§]˜P`šÛ5Õ n7_oâ%ƒp7h]9^wiüÙ3ƒ6sT_mØ-r4×[U (ä>Õìë(/3–íÊüº “ÏŒdœşF«‹š8'IÅäw;»‚nùÛ2ã5XÏK½æ“Upi2¼Ş\ t–Ö$:MnûÈ­Kã¿ØCi »Ãwp€ö‹€Á)7Ş¬Õ9IŸºa3Ô r [£~ÆÅb7]©W3—AòŠZØ3l½]XÊ3qê;ROf¾ L°ÇĞØÖn{–.†ÑÜÄöK”]âCUı.ı;ùÂ éˆ7‡C"¬ËJBæÚ/U<=`?‹&ù2êE(ÚÜ,P‚z¦ºöMì¤G7Q0	ˆêÙ'çßÌ¤Èµú#g;^#O‘ !èà'Ù<y²>İµüİXm|ù•×„…RjUz±ïm­,KT¨wµ­‰¯ti£ï(u^ì\:7NÑß¥\1QÇïÙe+OºDîôşÍÎ°–ß/X×ÚNÑDa’ñùôÃüÍ—‚ä-}Ÿ‡ıQzR€'ÄĞ|ÙvD£–îWÛARFM eÛåép&4ˆg=ÓM¡ƒ»@r»O¨Å. ½vTXrF£ç(˜#ÎpÔZ%pıb„oŠ¸—Q©>x=ôØu+YÚp^½ÿŠb$­-Oš‡X/~´òqy:€³…NJöÄT	6´J”Ê^'Æ|í_RÉÊZl3yº"Â®b¨î(Få~å£¦ë&â’â~/üB–±şi6N¥èNÍqa#Ùé]”g 6yhW­Ï*"ÕÊ<4¼n‚ÿª§H!òÍ˜gë¿Æ"Â'`‹ƒUXÍ½Ök	R¶Vdå
érŸeÙôo0šqÁéT×±‘wwÊm	¹ô±a(·äkbJ½„©"¦ÀfFªjeÔcĞ‚¤Ï9>VŞÿ< C,d»¥Şï_\=Y“=’7&©o”fó[«6,ÈñĞôÁ‘1Í¶-8Ñ&à®O¤
z]+Kpô+îÄ-Àiò…>¥¹õ€-¼_Ñ0ÚmAdm&2…ÁLD¤Û<Œöo8ÌÕ6Û7PÖ¨oX,Xmô£,¨k|foGJ…Ğ±¶Ò‡a1|Ğ5!©økºX¢°N€EÏÅ+O²7eM»ĞÙ€İCÉ»¹Wã+ñf˜ğ>ïvcíX­uùV11<Ö•7‰B»wSôu7ò–BQ÷ÚŞßLô/&Z±<¯N<F1Şß\¯:±ƒNÜ 	éXg¾`.³ĞTDm]ek¤Ç»I¼âRŸÏ`ù(dÃ¶ôMÒ<V¨ˆErêöM…P¦Qß_ªÁ!ğUÉ½·¾Ô3í¿æßĞšbQ'òüØï±’ÙUÄÓ½ãîqŠ>3i{­V‡7{re«³,ƒËÈéO¤%.ç;ËƒğšÜV,Œ'W´ñÖEçvYø«NóDßĞü7+¡•ÖË|¹çµÃÁD“.Í\âÁßHïøÃ'®BùEë[´ò¨ªCÖ’\Éö	½Eàf½Z4"; ~šÒtİ/Ùûº‚È‚Ê‰kUemtÇ{O£®áP}òÎ)çé(Ã(eæ‰z0NœE;Ô3ï
7Új¹W˜,ÛÙR—ıİ_tê‹bhNŞKE´0ÎRÆ|¸Yb«û5QqÖƒ4ò¿Qéş½}/xC¦¶ÛSÌy•3·g áÄ¼¹ÌVS§Œ—*vÓ¾ÂN+¹ ›Tİ´UÄ9¶Ò]‚-İ|¡ÖÊ×óÖ±r·Ï“@Z‡/êCšüµÿ1Á·ÁIØ­	NE‰
ŠZ%Q€áK’yônæ¿1Î«,§T÷Ím60uÓú¢\ª2÷Í6Ï|A¿
ÀÚ‘#(…XplÑÜdè+C†0ÏZ¤±şK	ª–µì…6‹ã""‘Pèe¡Œ±—í$ÿa[¶›«–op½CúÜ7–Ãm~BY\š¾ª«C÷ª7Öµğ@4ş3r´Ş*—œZ' A;Y‹
Æ^Ò}D»àìˆDèÊÊVÛ?ƒíAØ›k	¢~öj]XÇNø‰ÇÏ²B«#ƒ5˜vˆwª«åÂw\§1Zƒ„NxNÃ>¦çÅ&§G÷ù{“=³^ÏLà²8+GŒöQGZ3]¬h÷+P°6ãÆ	¯Ó©ƒÂàY»DUé#ÏY‘€P/<!gÌT‰×]½ó¸Ù§ı>WH)Ù
h°Í.xÑ+OöfÈ_»ùòfzn·`ÀÍV˜õ×õ^º4sıÌqW@ã¶R73”µ<cï³Û#Š‹Qïó&×ÔÛí#Ğ¯
#S\d‹İ>ÕİÊàüŸñ{Wl=6„"B˜á“ğöœS‰ÑÕUƒè•j¤°há!Xöüä¬ =ÈOO¢U‘$)ğsÚÓÉ‰	E5ƒÓÂÂåçPhH‡š
¹[.’ ¹k'Ï'=>¹/çğ|áx_U¢;¨¾y!ÈˆK›^Ö•èŞ16İåHÿŒ}$º•)Å3ÿD™ŒXáj¢1-ÓíJ¶J9ƒ¡Ò®=B®'„Äİë»‡}!7œ'v5¯6Ä÷V’œ§#&ªL×õîÂğ…ŒÆŞzÉ¾šö2
”FÜ» l]¿ì<	ö.Ì¤“¼¹óJ94gKİuÃü·Ëì½òÂò!Ò†q,fĞ¥ÂæC<9†4¾”¹éÚ2€æ<j¿yÑMŒïà‡gdˆ‰¹à‹²¡X¿DáBF§š~ç/ 3e#åUÕfPA“¶€06ø“àƒòøŠllF36É»êĞÒ,Å¼£0"éÉv’Àó£%K–%Ô6è’ù¸,¦³löyßGc¢Zÿ! 2û({ÎSJ—ïêlÏşÄÛ]Çß›t°<j‡ÕõñÆQá"‘,%ğÑSÖšô2’7–?b’!§—0â5£™G]»œÃŒ	˜QEÚ„öŠÕ½S¿ıÿ ^
ì¡jgzÃuÿ&u¾G
¬:Òq&ŸU¢ÃéQ¡V“”BìÚßYmÄj£`ª™”ÒØú©sÕ|j}ªıò§•¡L[jèBy^A,Mæ<»p`sºVyM¼ã®5È_ÑF‰!}MY++`—{é–"ì›	ˆ"-3JE'Ò¥´Éø»7]JÒeêÙ0ö…Q‰Ö·+×w"Ö§½¥2G‚Íé—«0´È¡Û¬´îŒCİ>X/uO²‹D	+)«2)‹ÅÒìà# ıé¨Ÿ|ÌIää;seCóôÛTLX•ü(9{jé,ËÌ;\Yİïs"àûİ‡l4üŒq%Òji.Ò/s„]&§ñ”FÓjûóŸª–3C¼ÎgÏéİ13MybÁÖöû¬Uøú¹áôı¯Ç[ŞWœ¾~h‰ëVN±Qª]Š”dõôé›âJî±¶g´‡p÷zÊm¹û°ã.X<—P»èù\´ù–»"²ğ^í…¤äXÂÓÇÚÉ¡€ÿÇç¥é¿¸R&Ûú^ãè¹öİ/ƒÓƒ›‚’=_ÅuoÆjÚ( X"ÁÔ"Ì¾uò/Úv³‘zS/è¿ÔçîQ‡ÅE×ŠZÉLbd‘çB;‹¥	Ö+/^”æ™ò m¢BfGHVÃDk®Z	Ä¹6Ûx†íôv8ÓŠ¦&J1~³Úµµ­g	€TˆÈã›×º‰Åƒ‡;§NË\U;;wwá8“…i˜<
¤ZíF†«üšÌ%ìëW³éÍ‚Pw'ÛÃ0Oó¿G™[õOb8kA‘­şĞÆï÷Ê›RßŸ²<r>½[¦AQ
·°«Ä–4,–9'ÊÈ%<Òv)¤b)¾™bm*‰˜éÅ÷0u£#îFÍ“VÉ+u&êxCª‹Fëb"d»ÏDıB‡¤8æ*U‘5–—éÊgõúi‡Šìğ€%æÖ²±LšCıÉÏ9€À¼1?õÍî@+g34N»…Ş²nŒÇtİOCdµõ}+Ì+„_‹FäîiGÈ W\¡Çõ¼š­1¬É!”XW‰Àá#‘ó±éuø²ó@ş6…‡‘¨­ ŸªŒ›—ğ°‹’ÅNl‰—1dĞ:Ì‰HTS´¶kcÊrï£§ÀÖ-Âj¢”§‘“˜>aé&Í¨ÁÈlõU¢ñvæ!M wiV_ïbîx/±¹n±ÛÄ;FGº
@¹•'¹oÄ9•Œæ'C#ŒF%÷ñ€SÑ óbq‚5B¼®ŒrvÙkäAÁœÕt¹€ŞMÈe69ü½È Áª`yúFgÈ”%³#Ë4«n™4Š“–hfc´7-ÄùÑï…rÅ|®&!LÄAôÊxêV‡.¶âÀü‚sÕ–F}—²Z«·úñp²6’
=Võ2y€î`v,¦`&ñà¨ß–@éGBù±s™·çáFTbî€ÒB“ïo‹$#ôSÖdFş¾º4ˆşd™
´3öéÇYFdÉœã^èéGCµo“ËÃ¿”›xº7Î¨6„»2ÛÌÏ$®åØCÖKP¼)ÎL_c·W„×¼Îáæ‡µÜ–À`„]?Tô¢!›(õ´+‹U¾=–¸¶ô•ë-*yvMÉ%¢Š]	mıˆá÷h'yóæöÇş NU9—\˜›ÍöBonÃ™’P#'1™4sIt=j©T“&Èö 2öOé¯ĞîV2ä± m»?¦“ìt¯Œœñ·…’WpP&ş~ø}jQ&S›áühB<œtùë.v ü¡ŸÒ´³W¬	'8íZUÁ'àWi“ø~X]ßı‘ŸîXU°[bÌÊ0p—DåáÙPæËÊ¿^ç­°RLÅb¥Ç¼@O+Îc€g÷7†R¼ÒN÷µœZu"ÖÊü —µiö¡“Ó©N’B.µì1ÏºM¬
×ºø±=‹2¸–˜}$â¢9wèl”rÆ±EC‘:¡é|óK¾îú*LéiD_Ó$-»Êµ­6E¤¼/¢a”|¸C%UÚæ‚cñi.”Œ:QzÍo‚æ9“l]’PhÍà|R‹ˆu
1?Il76—máªJ ß¢É©&‰à“¼-ÄÄ«ë#¸õ"Äê?#\¬Ğ¼|e2XGñ*…mOéàè0‹>2¢H5ay ÄØŠf–‚à
Õadkš[lC(¶P¾) ¾†¹ÍèÌ<Ì"R²rï|6šÌlë7Ë¬MTÅ´«°Ä4 ‹EWn]”Dê?:ñ?ü„-ÈìX—=ì[/dâî¾êéºrÜWª£ñ3æÌ^X:æ°n4ÓH7ËBŠÂ7úÀtšÜªÆ… }ßŒ×·]”YˆÒC–‚Ñâ~™çstÿ¦P>g~›«z¾–™ … qÏØ9Itë9«3«}BÚKDK.JM”’İó©Ù^³9 .q!ÙÉ¼^(Ôé]Dê®Ops%µ±ˆD® éjZ]RîİÏŞùDi	xË€˜Yq†eğ?g&1šBEoD¥ŞÄA+6¿QoîñåÎæô¢I\äB(ñ8Çì1ßÖTCQŒÕ­¼h¸œ°|±ßş?â,cÛÁå…EGæÇÊ4íØz:W£ìUYİºsLU
äa90™$9ó}P –Aé3´…[VF,Âê´İÏœ Äş ”Xh·À¾í¢12%g½A@Â™{C|œ‹O¶´«×àŠQ/íî0Z¸3àîá]}w4¿˜t…¹/©™·›áó$è|]İ|;ßRºñ‰F&·ëy3á
)Lbá'çªV1}j@ë?Lw^&ëá±•uID¨+¾á~‚ñ1H§ûç—¿<È]ä,i#À'¯Z 7FşÙf‚°ô|UÈÁœşeÓˆ‘‹ö†¦:Bõã³¯‡ÎdQkûhÚŠ•óŸ«j3À9DQc0Â"f–3¤ñÜi;ÏšŞ†F‡'Zlªc|©³òóeAÉP…•`%‰+ZE¿/º›]´œ”Á‹¬á®ağrØ&Šû	.+/ãŒ-Á7mŒ¦\vÇ×:¹‰º_T,_EüEÓÍéJÛ3İ±_`NzŞ&Yã5ÛäL"%¸ƒ*§)¼¤+³ßÚä³*ĞVn5¤mƒã)$«ÙÔ6æW† ?áª·+$C@†L‹İQ/$u"å=hTÂ$vå9§ó¾ê1äœ¢¥Ä—í%Šs0Š˜ÈcCâ°âõ¦«àºäeÕæ‚·2™xóêPs–Õ*ş+tÃµ.Ë ûX« ÿq·´‘	:‰CzíyÖDã÷7'4ÕËÒ5;#âQ;‹"êÅª2‚Ò˜ °›•0ı¶1Ví÷Aª8O¦]q@éÃ)ñOÆ[×È¸n€mbËÙh4pıJé3òş¥_ÔÅ í1ÖT­-Iæd§\W1äGÉÓ0D¤X'íä¼m³nHšvof¡0Ïäd¦g|ŸzÖ>LAäÓi¥Ğ`é'8Ï&½¬D‹muœKÅ{ğYÛğó‡7ü¯‹x*/]Ù‹ƒöcŠ"ÓÆ[s„e¹ÙAÒdŸ=¤¥U4 ˆ¤=ï4ÈQg‡ÇøÇ¯Ë:FH¬?Ämë5òàÏÕä©Nó.úQÉ1îÂT8ÜÜB¹-ÔİwM;?ğ!À…ß¶Ú³|ãªq5ˆ™8¢J©:=åg†¦-l«Î$‚ŒRÖ¢›„ÀgÁg
z$}ÕØñ™:×ŸÜb×/3aÖÉÈ”~7WÅØŠ,¨D"ìK;P6T¡m2Ìs0O“á´·Ô!7$7[>òk4ÌKS”¶0D'ob&‘01…ÒÕ;˜ÙsÆTW–y¸É8ÜxúØ;FY0SX<õ”}ß_¼X-®ÜÉ*ãÃ”¶æK›FHÿÿ-›IÏ§ªøŸTÇ¢fFrz»àÇÎ`šŸEUŸàqjõÙ•ş´‰Ùf+{/¢‹iC.Auw/_&‚“šĞúîoŠ°­×¥õûïBc{øö	ó1·èå¤½„š¿X w«4l¯»“VkıéK“Ù |êWqG*¡UÏQêÀòG·.	Á·¦ğ¸Fzkõ<‚ïÇº±€â†ÀcUZº{5Åõ´ÁøÉ3+¹;;Áµ»«¯ı¾ª¢
¯z¨-¶éË_öw^U“®¦İÏ>fì¸º˜»GöªúXßİV“Y¾Ş×Z‰øq´Ãp’ÇYf ÚuWm/YÂËÀGb/fäÄ°ùH;$"Ö<»W@¤²‘«çõ°„ØÖdÅ´9µÑš,;ˆîòäœhëˆÏ\„‚SxW²|÷Ÿ'r¢¯b~Ï@ïCÖO^¤”"8ƒŒkĞu7¡H€*a®uçÛ×|Xy‚ù”qW ÑÖ<)£|‰zKíƒÚ“‡ú²H E—YÃ›Zô#dÎ‘Úápe„\“’“ÉäÌHï,Á‚ŞBå_¬¿ÒÏ8¤@ó³É”äşƒQw˜} ¨œÑğºC——kÏªeè4xïî‰ls¿Ÿw¢Hn/¸%¾Î1ïjysÅvÂ5ğá´_®¥2l9»ªÚ(„&\¡›#ÎÍwQ}ÖÕˆ'>‰ØÈ@É L”ãä*Í^+à”/Ù»ú 	s`æ ”ç;ôQmä5U‡Íú||Òù¹S™´{×nÛ/ŞŸ@'	ørsí^Á1b#<c—5n­ÂB”ÌNGb(4yµï¡ÄUeL“_ÑY¬];I#ğC9°5$s‚i9eÙX-)\„Â²d+#éÈD&ˆÇWå¤P y¬z¶H{ÆÙà€C&¤í5ğüğ‚Ìï?-èÙÖò•AÁ1nèŒ×ùüt‘Ñd²—B­Xîˆ!¥4ia½šè—ÅÄv$© œ	µšø5;‰Á ÿ£êåq2£fA+bFŠ44êizó1’=m[îù¶`¸´QŒsÈyÎzÅ.²HÍwïøÔ2ˆ: ÔËøÅm
Æ^œëü/³±F'ğü äb‡%-ÍÕ¿Ëë‰#ãŒİ”¯Çí†7e5ÀÙJ
J­¯şbw¸'nš<SXÏáR;Ğ-b¨BÕ2­¬Ğ5u‘É,ı°º¾ÎzX&=æ§¦œ‚‡Ç[Aî1Bı	Ÿ?ù`ùoºí¬$.Drü‘”‰ÔDú÷3¥$ñÿ·ØñNù­üØ°ãí²g#XÊBî/«ktıkºHÍ…C?pa
T…of–¬cßaáZ¾‡“TØJ"¹¸àêàñ’³‹™Ø…{5ÆA7µ­9îvl(åú¯KšúÎ+nx@»¼µØ Ê´:ìLû ¹à•mğã¥ŒßİÛÒ
@moÄ¥Ll+&`úWJû'¯şFI¾/Ç¦¿5ö™*'(ë$ÂåÊHd–”'T#›Òuñ½gÜ~Á·cg­¿,^[”Ù£ûÁ´-ctfå×òèÀ­Ñˆù/je—y9Uˆzo"„‘S¡Zœ©Í¢O¤k"5|ßW€±E>OÖï¢ÜOŠúu*·¥œïúØ×s3A­/Î·	”ëº«ñ‰zIõiûŠëÏºïí±4ßö»~MÃ®'Éá!Ò¶*;h+õÉ:ê¶H¢4å¥¥k¡x$hÇâšjŠ¾@@ÈÎV”ÇÎ‰°Üa)§Û¬L9-Û›éï|õ¿Ë2®Ä£ÕOh¸á§aDk’ú5#É²©ÖŒ]—>Ù(1ÌIî
ò$m8ÃÚ”»ü;Š‘uGP1ß/.ƒ9…ëûJşÜ]À´v¯EÅßß¶\m%um{„ğ¿‰İèIO”Ö¬@«S]š^AæzW‚ éşv•ËzÜ,ûxâ¯ê!u öıË´qó?¥ïäQxŸ¡I¨)¨ò/—£P:fvmœXÓğŒ2pGs4a2½¦“1Ş×t‡ãuÇËvÌ=Êá.Ïéy@9»)»‰LúãÔÔK<–—ƒ¤Ô±¼«å‘#\^/"6kïéÿá7b1AİÍ[Ğuh’ÿ=`øŒ´¥Ô™Š%×s‚¨ïY‰¾æ·‰¥L]"ôá}ù›ŒiHŒ@6Û(ı,´†Ämİ
rmÛGÊ|?ìÍe÷f ^=ö¸w7xnfÿ‰wåüó¬j~:›kã—¬ %ú…—ñb—\8WL‹‚:¯>/‚ şŞÉV2á6ú:†Ê©>0Ôñ/ÛÄ*Ö2ÒÜ£t`X1Óiâ«áéG«åj#—;ù†¿¿6Ó)ÁĞPJ	t/ÈS\?Û Ñİ->½MÏ)Øïkßã1ï*…˜N¿¬ær$äæŸãÃù‘s+ä]zKNÈÆ
Ìé‘¸jH‘Rì¾’‚¼Ø›ì/	Ü:dÆ$A†A1`Ùß¤w«Ê<¸€ş†´9Lq½—©[MÂcìä|¤¿ÆÔb»¶ìò¾şÕd>a¥pÙ9u!AÌƒğÉùÜBFC…×My?şêôòœƒfmİ±å‘ ¾šìíşHu=¦`G'æá¢"¾7ı%Óqö»¹Û*\F'`š#ÀpÖßÀ=4Y‹À9Äp=‹IĞ|AC÷¥«µ„¡PÙCÑOäHôW¦æä<Ñäˆç
ø—òê
lÃ>(ØXÊ›»¯œ7«İk1EERI3ì¯Ğß4JŠ÷Œ ½#Åˆ4ği¹(ì1«R˜/’£¥Jé¾L™îáï^dÚz/!øÃHéO ë÷Fôb¹9‰î5¡,ÁóvÍäyöÅÜˆºškK¨½™n…/@<JÈê¡Éc­HIÉ¥Qëk:Ššj{i
ÿ…ˆ¿‹şó˜³»çB³E—t|k›í94™vÑœZ14Ã~DwµFÖ#U+ì†Y2ƒ”µC0M‰8ñ†ïÄ5E¥¥tƒO (zìX¦Õ@+D[ñW*mì£˜c²·°Ç¯Ë™y! ªw@ä†%*q¦³‹Z
ÒñT‡\Fy?õ»ıåacHÛÁqXq:c:&/ 6(ƒÿ½ªUÜª°İÛpµíÈEX-Íã/öïücÃe„Ğn"H³ OrõôıüÏß… ¦ú[µÌ¦tR6„vĞ…ôR…ô*ãàaÍN®w÷QØT ÍÂúa&—HÖÆ¥»Ñ—vZÛ¨Ï¥Hô3#Ë å:’ 2>ÆçË&cö˜hş3¤ ˆ8"ÓÊ ¤i¢S“-ß8ş&¼! mËSˆƒR”²'~ğª2l+š@ïİñHû"Zk/Bâ‡´:@<c­½G9¨~kBÓ½\“jœÖº¥Óë>u­Ô¹gÃ~Vt46ë¸wù}U(Â|-,Ág—»kW™Ú
‹/ ~Úlûá
rJò–ßì©+ym!Ğ61ÄU/Ë/›æö·z,'w\In½EÚ€½–Qdp3¯¥õÎóyü Æú'`ôZ³ğŸ¿cİĞç»EşX´ãóf+™¸õy~¾"Œjİ®û°
 }$¾½ÈêŠwnÅ>†\7„Ñãc©t3ãÚNá8äL¡f‰+D?0%¿¿(
6ú)}ãóÃå~Ø/F‰¶ÃÌkú 4ğn#¬†¨amedProgramLocalParameterIivEXTPROC)((intptr_t)function_pointer);
	glGetNamedProgramLocalParameterIivEXT(program, target, index, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetNamedProgramLocalParameterIuivEXT(JNIEnv *env, jclass clazz, jint program, jint target, jint index, jlong params, jlong function_pointer) {
	GLuint *params_address = (GLuint *)(intptr_t)params;
	glGetNamedProgramLocalParameterIuivEXTPROC glGetNamedProgramLocalParameterIuivEXT = (glGetNamedProgramLocalParameterIuivEXTPROC)((intptr_t)function_pointer);
	glGetNamedProgramLocalParameterIuivEXT(program, target, index, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedRenderbufferStorageEXT(JNIEnv *env, jclass clazz, jint renderbuffer, jint internalformat, jint width, jint height, jlong function_pointer) {
	glNamedRenderbufferStorageEXTPROC glNamedRenderbufferStorageEXT = (glNamedRenderbufferStorageEXTPROC)((intptr_t)function_pointer);
	glNamedRenderbufferStorageEXT(renderbuffer, internalformat, width, height);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetNamedRenderbufferParameterivEXT(JNIEnv *env, jclass clazz, jint renderbuffer, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetNamedRenderbufferParameterivEXTPROC glGetNamedRenderbufferParameterivEXT = (glGetNamedRenderbufferParameterivEXTPROC)((intptr_t)function_pointer);
	glGetNamedRenderbufferParameterivEXT(renderbuffer, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedRenderbufferStorageMultisampleEXT(JNIEnv *env, jclass clazz, jint renderbuffer, jint samples, jint internalformat, jint width, jint height, jlong function_pointer) {
	glNamedRenderbufferStorageMultisampleEXTPROC glNamedRenderbufferStorageMultisampleEXT = (glNamedRenderbufferStorageMultisampleEXTPROC)((intptr_t)function_pointer);
	glNamedRenderbufferStorageMultisampleEXT(renderbuffer, samples, internalformat, width, height);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedRenderbufferStorageMultisampleCoverageEXT(JNIEnv *env, jclass clazz, jint renderbuffer, jint coverageSamples, jint colorSamples, jint internalformat, jint width, jint height, jlong function_pointer) {
	glNamedRenderbufferStorageMultisampleCoverageEXTPROC glNamedRenderbufferStorageMultisampleCoverageEXT = (glNamedRenderbufferStorageMultisampleCoverageEXTPROC)((intptr_t)function_pointer);
	glNamedRenderbufferStorageMultisampleCoverageEXT(renderbuffer, coverageSamples, colorSamples, internalformat, width, height);
}

JNIEXPORT jint JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglCheckNamedFramebufferStatusEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint target, jlong function_pointer) {
	glCheckNamedFramebufferStatusEXTPROC glCheckNamedFramebufferStatusEXT = (glCheckNamedFramebufferStatusEXTPROC)((intptr_t)function_pointer);
	GLenum __result = glCheckNamedFramebufferStatusEXT(framebuffer, target);
	return __result;
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedFramebufferTexture1DEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint attachment, jint textarget, jint texture, jint level, jlong function_pointer) {
	glNamedFramebufferTexture1DEXTPROC glNamedFramebufferTexture1DEXT = (glNamedFramebufferTexture1DEXTPROC)((intptr_t)function_pointer);
	glNamedFramebufferTexture1DEXT(framebuffer, attachment, textarget, texture, level);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedFramebufferTexture2DEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint attachment, jint textarget, jint texture, jint level, jlong function_pointer) {
	glNamedFramebufferTexture2DEXTPROC glNamedFramebufferTexture2DEXT = (glNamedFramebufferTexture2DEXTPROC)((intptr_t)function_pointer);
	glNamedFramebufferTexture2DEXT(framebuffer, attachment, textarget, texture, level);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedFramebufferTexture3DEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint attachment, jint textarget, jint texture, jint level, jint zoffset, jlong function_pointer) {
	glNamedFramebufferTexture3DEXTPROC glNamedFramebufferTexture3DEXT = (glNamedFramebufferTexture3DEXTPROC)((intptr_t)function_pointer);
	glNamedFramebufferTexture3DEXT(framebuffer, attachment, textarget, texture, level, zoffset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedFramebufferRenderbufferEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint attachment, jint renderbuffertarget, jint renderbuffer, jlong function_pointer) {
	glNamedFramebufferRenderbufferEXTPROC glNamedFramebufferRenderbufferEXT = (glNamedFramebufferRenderbufferEXTPROC)((intptr_t)function_pointer);
	glNamedFramebufferRenderbufferEXT(framebuffer, attachment, renderbuffertarget, renderbuffer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetNamedFramebufferAttachmentParameterivEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint attachment, jint pname, jlong params, jlong function_pointer) {
	GLint *params_address = (GLint *)(intptr_t)params;
	glGetNamedFramebufferAttachmentParameterivEXTPROC glGetNamedFramebufferAttachmentParameterivEXT = (glGetNamedFramebufferAttachmentParameterivEXTPROC)((intptr_t)function_pointer);
	glGetNamedFramebufferAttachmentParameterivEXT(framebuffer, attachment, pname, params_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGenerateTextureMipmapEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jlong function_pointer) {
	glGenerateTextureMipmapEXTPROC glGenerateTextureMipmapEXT = (glGenerateTextureMipmapEXTPROC)((intptr_t)function_pointer);
	glGenerateTextureMipmapEXT(texture, target);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGenerateMultiTexMipmapEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jlong function_pointer) {
	glGenerateMultiTexMipmapEXTPROC glGenerateMultiTexMipmapEXT = (glGenerateMultiTexMipmapEXTPROC)((intptr_t)function_pointer);
	glGenerateMultiTexMipmapEXT(texunit, target);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglFramebufferDrawBufferEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint mode, jlong function_pointer) {
	glFramebufferDrawBufferEXTPROC glFramebufferDrawBufferEXT = (glFramebufferDrawBufferEXTPROC)((intptr_t)function_pointer);
	glFramebufferDrawBufferEXT(framebuffer, mode);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglFramebufferDrawBuffersEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint n, jlong bufs, jlong function_pointer) {
	const GLenum *bufs_address = (const GLenum *)(intptr_t)bufs;
	glFramebufferDrawBuffersEXTPROC glFramebufferDrawBuffersEXT = (glFramebufferDrawBuffersEXTPROC)((intptr_t)function_pointer);
	glFramebufferDrawBuffersEXT(framebuffer, n, bufs_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglFramebufferReadBufferEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint mode, jlong function_pointer) {
	glFramebufferReadBufferEXTPROC glFramebufferReadBufferEXT = (glFramebufferReadBufferEXTPROC)((intptr_t)function_pointer);
	glFramebufferReadBufferEXT(framebuffer, mode);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetFramebufferParameterivEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint pname, jlong param, jlong function_pointer) {
	GLint *param_address = (GLint *)(intptr_t)param;
	glGetFramebufferParameterivEXTPROC glGetFramebufferParameterivEXT = (glGetFramebufferParameterivEXTPROC)((intptr_t)function_pointer);
	glGetFramebufferParameterivEXT(framebuffer, pname, param_address);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedCopyBufferSubDataEXT(JNIEnv *env, jclass clazz, jint readBuffer, jint writeBuffer, jlong readoffset, jlong writeoffset, jlong size, jlong function_pointer) {
	glNamedCopyBufferSubDataEXTPROC glNamedCopyBufferSubDataEXT = (glNamedCopyBufferSubDataEXTPROC)((intptr_t)function_pointer);
	glNamedCopyBufferSubDataEXT(readBuffer, writeBuffer, readoffset, writeoffset, size);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedFramebufferTextureEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint attachment, jint texture, jint level, jlong function_pointer) {
	glNamedFramebufferTextureEXTPROC glNamedFramebufferTextureEXT = (glNamedFramebufferTextureEXTPROC)((intptr_t)function_pointer);
	glNamedFramebufferTextureEXT(framebuffer, attachment, texture, level);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedFramebufferTextureLayerEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint attachment, jint texture, jint level, jint layer, jlong function_pointer) {
	glNamedFramebufferTextureLayerEXTPROC glNamedFramebufferTextureLayerEXT = (glNamedFramebufferTextureLayerEXTPROC)((intptr_t)function_pointer);
	glNamedFramebufferTextureLayerEXT(framebuffer, attachment, texture, level, layer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglNamedFramebufferTextureFaceEXT(JNIEnv *env, jclass clazz, jint framebuffer, jint attachment, jint texture, jint level, jint face, jlong function_pointer) {
	glNamedFramebufferTextureFaceEXTPROC glNamedFramebufferTextureFaceEXT = (glNamedFramebufferTextureFaceEXTPROC)((intptr_t)function_pointer);
	glNamedFramebufferTextureFaceEXT(framebuffer, attachment, texture, level, face);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglTextureRenderbufferEXT(JNIEnv *env, jclass clazz, jint texture, jint target, jint renderbuffer, jlong function_pointer) {
	glTextureRenderbufferEXTPROC glTextureRenderbufferEXT = (glTextureRenderbufferEXTPROC)((intptr_t)function_pointer);
	glTextureRenderbufferEXT(texture, target, renderbuffer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMultiTexRenderbufferEXT(JNIEnv *env, jclass clazz, jint texunit, jint target, jint renderbuffer, jlong function_pointer) {
	glMultiTexRenderbufferEXTPROC glMultiTexRenderbufferEXT = (glMultiTexRenderbufferEXTPROC)((intptr_t)function_pointer);
	glMultiTexRenderbufferEXT(texunit, target, renderbuffer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglVertexArrayVertexOffsetEXT(JNIEnv *env, jclass clazz, jint vaobj, jint buffer, jint size, jint type, jint stride, jlong offset, jlong function_pointer) {
	glVertexArrayVertexOffsetEXTPROC glVertexArrayVertexOffsetEXT = (glVertexArrayVertexOffsetEXTPROC)((intptr_t)function_pointer);
	glVertexArrayVertexOffsetEXT(vaobj, buffer, size, type, stride, offset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglVertexArrayColorOffsetEXT(JNIEnv *env, jclass clazz, jint vaobj, jint buffer, jint size, jint type, jint stride, jlong offset, jlong function_pointer) {
	glVertexArrayColorOffsetEXTPROC glVertexArrayColorOffsetEXT = (glVertexArrayColorOffsetEXTPROC)((intptr_t)function_pointer);
	glVertexArrayColorOffsetEXT(vaobj, buffer, size, type, stride, offset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglVertexArrayEdgeFlagOffsetEXT(JNIEnv *env, jclass clazz, jint vaobj, jint buffer, jint stride, jlong offset, jlong function_pointer) {
	glVertexArrayEdgeFlagOffsetEXTPROC glVertexArrayEdgeFlagOffsetEXT = (glVertexArrayEdgeFlagOffsetEXTPROC)((intptr_t)function_pointer);
	glVertexArrayEdgeFlagOffsetEXT(vaobj, buffer, stride, offset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglVertexArrayIndexOffsetEXT(JNIEnv *env, jclass clazz, jint vaobj, jint buffer, jint type, jint stride, jlong offset, jlong function_pointer) {
	glVertexArrayIndexOffsetEXTPROC glVertexArrayIndexOffsetEXT = (glVertexArrayIndexOffsetEXTPROC)((intptr_t)function_pointer);
	glVertexArrayIndexOffsetEXT(vaobj, buffer, type, stride, offset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglVertexArrayNormalOffsetEXT(JNIEnv *env, jclass clazz, jint vaobj, jint buffer, jint type, jint stride, jlong offset, jlong function_pointer) {
	glVertexArrayNormalOffsetEXTPROC glVertexArrayNormalOffsetEXT = (glVertexArrayNormalOffsetEXTPROC)((intptr_t)function_pointer);
	glVertexArrayNormalOffsetEXT(vaobj, buffer, type, stride, offset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglVertexArrayTexCoordOffsetEXT(JNIEnv *env, jclass clazz, jint vaobj, jint buffer, jint size, jint type, jint stride, jlong offset, jlong function_pointer) {
	glVertexArrayTexCoordOffsetEXTPROC glVertexArrayTexCoordOffsetEXT = (glVertexArrayTexCoordOffsetEXTPROC)((intptr_t)function_pointer);
	glVertexArrayTexCoordOffsetEXT(vaobj, buffer, size, type, stride, offset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglVertexArrayMultiTexCoordOffsetEXT(JNIEnv *env, jclass clazz, jint vaobj, jint buffer, jint texunit, jint size, jint type, jint stride, jlong offset, jlong function_pointer) {
	glVertexArrayMultiTexCoordOffsetEXTPROC glVertexArrayMultiTexCoordOffsetEXT = (glVertexArrayMultiTexCoordOffsetEXTPROC)((intptr_t)function_pointer);
	glVertexArrayMultiTexCoordOffsetEXT(vaobj, buffer, texunit, size, type, stride, offset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglVertexArrayFogCoordOffsetEXT(JNIEnv *env, jclass clazz, jint vaobj, jint buffer, jint type, jint stride, jlong offset, jlong function_pointer) {
	glVertexArrayFogCoordOffsetEXTPROC glVertexArrayFogCoordOffsetEXT = (glVertexArrayFogCoordOffsetEXTPROC)((intptr_t)function_pointer);
	glVertexArrayFogCoordOffsetEXT(vaobj, buffer, type, stride, offset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglVertexArraySecondaryColorOffsetEXT(JNIEnv *env, jclass clazz, jint vaobj, jint buffer, jint size, jint type, jint stride, jlong offset, jlong function_pointer) {
	glVertexArraySecondaryColorOffsetEXTPROC glVertexArraySecondaryColorOffsetEXT = (glVertexArraySecondaryColorOffsetEXTPROC)((intptr_t)function_pointer);
	glVertexArraySecondaryColorOffsetEXT(vaobj, buffer, size, type, stride, offset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglVertexArrayVertexAttribOffsetEXT(JNIEnv *env, jclass clazz, jint vaobj, jint buffer, jint index, jint size, jint type, jboolean normalized, jint stride, jlong offset, jlong function_pointer) {
	glVertexArrayVertexAttribOffsetEXTPROC glVertexArrayVertexAttribOffsetEXT = (glVertexArrayVertexAttribOffsetEXTPROC)((intptr_t)function_pointer);
	glVertexArrayVertexAttribOffsetEXT(vaobj, buffer, index, size, type, normalized, stride, offset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglVertexArrayVertexAttribIOffsetEXT(JNIEnv *env, jclass clazz, jint vaobj, jint buffer, jint index, jint size, jint type, jint stride, jlong offset, jlong function_pointer) {
	glVertexArrayVertexAttribIOffsetEXTPROC glVertexArrayVertexAttribIOffsetEXT = (glVertexArrayVertexAttribIOffsetEXTPROC)((intptr_t)function_pointer);
	glVertexArrayVertexAttribIOffsetEXT(vaobj, buffer, index, size, type, stride, offset);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglEnableVertexArrayEXT(JNIEnv *env, jclass clazz, jint vaobj, jint array, jlong function_pointer) {
	glEnableVertexArrayEXTPROC glEnableVertexArrayEXT = (glEnableVertexArrayEXTPROC)((intptr_t)function_pointer);
	glEnableVertexArrayEXT(vaobj, array);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglDisableVertexArrayEXT(JNIEnv *env, jclass clazz, jint vaobj, jint array, jlong function_pointer) {
	glDisableVertexArrayEXTPROC glDisableVertexArrayEXT = (glDisableVertexArrayEXTPROC)((intptr_t)function_pointer);
	glDisableVertexArrayEXT(vaobj, array);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglEnableVertexArrayAttribEXT(JNIEnv *env, jclass clazz, jint vaobj, jint index, jlong function_pointer) {
	glEnableVertexArrayAttribEXTPROC glEnableVertexArrayAttribEXT = (glEnableVertexArrayAttribEXTPROC)((intptr_t)function_pointer);
	glEnableVertexArrayAttribEXT(vaobj, index);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglDisableVertexArrayAttribEXT(JNIEnv *env, jclass clazz, jint vaobj, jint index, jlong function_pointer) {
	glDisableVertexArrayAttribEXTPROC glDisableVertexArrayAttribEXT = (glDisableVertexArrayAttribEXTPROC)((intptr_t)function_pointer);
	glDisableVertexArrayAttribEXT(vaobj, index);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetVertexArrayIntegervEXT(JNIEnv *env, jclass clazz, jint vaobj, jint pname, jlong param, jlong function_pointer) {
	GLint *param_address = (GLint *)(intptr_t)param;
	glGetVertexArrayIntegervEXTPROC glGetVertexArrayIntegervEXT = (glGetVertexArrayIntegervEXTPROC)((intptr_t)function_pointer);
	glGetVertexArrayIntegervEXT(vaobj, pname, param_address);
}

JNIEXPORT jobject JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetVertexArrayPointervEXT(JNIEnv *env, jclass clazz, jint vaobj, jint pname, jlong result_size, jlong function_pointer) {
	glGetVertexArrayPointervEXTPROC glGetVertexArrayPointervEXT = (glGetVertexArrayPointervEXTPROC)((intptr_t)function_pointer);
	GLvoid * __result;
	glGetVertexArrayPointervEXT(vaobj, pname, &__result);
	return safeNewBuffer(env, __result, result_size);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetVertexArrayIntegeri_1vEXT(JNIEnv *env, jclass clazz, jint vaobj, jint index, jint pname, jlong param, jlong function_pointer) {
	GLint *param_address = (GLint *)(intptr_t)param;
	glGetVertexArrayIntegeri_vEXTPROC glGetVertexArrayIntegeri_vEXT = (glGetVertexArrayIntegeri_vEXTPROC)((intptr_t)function_pointer);
	glGetVertexArrayIntegeri_vEXT(vaobj, index, pname, param_address);
}

JNIEXPORT jobject JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglGetVertexArrayPointeri_1vEXT(JNIEnv *env, jclass clazz, jint vaobj, jint index, jint pname, jlong result_size, jlong function_pointer) {
	glGetVertexArrayPointeri_vEXTPROC glGetVertexArrayPointeri_vEXT = (glGetVertexArrayPointeri_vEXTPROC)((intptr_t)function_pointer);
	GLvoid * __result;
	glGetVertexArrayPointeri_vEXT(vaobj, index, pname, &__result);
	return safeNewBuffer(env, __result, result_size);
}

JNIEXPORT jobject JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglMapNamedBufferRangeEXT(JNIEnv *env, jclass clazz, jint buffer, jlong offset, jlong length, jint access, jobject old_buffer, jlong function_pointer) {
	glMapNamedBufferRangeEXTPROC glMapNamedBufferRangeEXT = (glMapNamedBufferRangeEXTPROC)((intptr_t)function_pointer);
	GLvoid * __result = glMapNamedBufferRangeEXT(buffer, offset, length, access);
	return safeNewBufferCached(env, __result, length, old_buffer);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengl_EXTDirectStateAccess_nglFlushMappedNamedBufferRangeEXT(JNIEnv *env, jclass clazz, jint buffer, jlong offset, jlong length, jlong function_pointer) {
	glFlushMappedNamedBufferRangeEXTPROC glFlushMappedNamedBufferRangeEXT = (glFlushMappedNamedBufferRangeEXTPROC)((intptr_t)function_pointer);
	glFlushMappedNamedBufferRangeEXT(buffer, offset, length);
}

