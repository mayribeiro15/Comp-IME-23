	.file	"instConvTipos.c"
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
	movzx	eax, BYTE PTR _c1
	movsx	eax, al
	mov	DWORD PTR _y, eax
	movzx	eax, BYTE PTR _c2
	movzx	eax, al
	mov	DWORD PTR _k1, eax
	mov	eax, 0
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE10:
	.ident	"GCC: (MinGW.org GCC-6.3.0-1) 6.3.0"
