	.file	"aula0903.c"
	.intel_syntax noprefix
	.comm	_x, 4, 2
	.comm	_y, 4, 2
	.comm	_z, 4, 2
	.comm	_k1, 4, 2
	.comm	_k2, 4, 2
	.comm	_c1, 1, 0
	.comm	_c2, 1, 0
	.comm	_w, 16, 2
	.def	___main;	.scl	2;	.type	32;	.endef
	.text
	.globl	_main
	.def	_main;	.scl	2;	.type	32;	.endef
_main:
LFB10:
	.cfi_startproc
	push	ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	mov	ebp, esp
	.cfi_def_cfa_register 5
	and	esp, -16
	call	___main
	mov	edx, DWORD PTR _x
	mov	eax, DWORD PTR _y
	cmp	edx, eax
	jle	L2
	mov	DWORD PTR _x, 0
L2:
	mov	eax, 0
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE10:
	.ident	"GCC: (MinGW.org GCC-6.3.0-1) 6.3.0"
