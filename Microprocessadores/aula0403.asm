	.file	"aula0403.c"
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
	add	eax, edx
	mov	DWORD PTR _x, eax
	mov	edx, DWORD PTR _x
	mov	eax, DWORD PTR _y
	sub	edx, eax
	mov	eax, edx
	mov	DWORD PTR _x, eax
	mov	edx, DWORD PTR _x
	mov	eax, DWORD PTR _y
	add	eax, edx
	mov	DWORD PTR _x, eax
	mov	edx, DWORD PTR _x
	mov	eax, DWORD PTR _y
	sub	edx, eax
	mov	eax, edx
	mov	DWORD PTR _x, eax
	mov	eax, DWORD PTR _x
	xor	eax, 30
	mov	DWORD PTR _y, eax
	mov	eax, DWORD PTR _x
	and	eax, 30
	mov	DWORD PTR _y, eax
	mov	eax, DWORD PTR _x
	or	eax, 30
	mov	DWORD PTR _y, eax
	mov	eax, DWORD PTR _x
	not	eax
	mov	DWORD PTR _y, eax
	mov	eax, DWORD PTR _x
	neg	eax
	mov	DWORD PTR _y, eax
	mov	eax, DWORD PTR _x
	add	eax, 1
	mov	DWORD PTR _x, eax
	mov	eax, DWORD PTR _x
	add	eax, 1
	mov	DWORD PTR _x, eax
	mov	eax, DWORD PTR _x
	sub	eax, 1
	mov	DWORD PTR _x, eax
	mov	eax, DWORD PTR _x
	lea	edx, [eax+1]
	mov	DWORD PTR _x, edx
	mov	DWORD PTR _y, eax
	mov	eax, DWORD PTR _x
	sub	eax, 1
	mov	DWORD PTR _x, eax
	mov	eax, DWORD PTR _x
	lea	edx, [eax+1]
	mov	DWORD PTR _x, edx
	mov	DWORD PTR _y, eax
	mov	eax, DWORD PTR _x
	add	eax, 1
	mov	DWORD PTR _x, eax
	mov	eax, DWORD PTR _x
	mov	DWORD PTR _y, eax
	mov	edx, DWORD PTR _x
	mov	eax, DWORD PTR _y
	imul	eax, edx
	mov	DWORD PTR _x, eax
	mov	eax, DWORD PTR _x
	mov	ecx, DWORD PTR _y
	cdq
	idiv	ecx
	mov	DWORD PTR _x, eax
	mov	edx, DWORD PTR _k1
	mov	eax, DWORD PTR _k2
	imul	eax, edx
	mov	DWORD PTR _k1, eax
	mov	eax, DWORD PTR _k1
	mov	ecx, DWORD PTR _k2
	mov	edx, 0
	div	ecx
	mov	DWORD PTR _k1, eax
	mov	eax, DWORD PTR _z
	mov	edx, DWORD PTR _x
	sal	edx, 2
	add	edx, eax
	mov	eax, DWORD PTR _y
	mov	DWORD PTR [edx], eax
	mov	edx, DWORD PTR _x
	mov	eax, DWORD PTR _y
	cmp	edx, eax
	setg	al
	mov	BYTE PTR _c1, al
	mov	edx, DWORD PTR _k1
	mov	eax, DWORD PTR _k2
	cmp	edx, eax
	setnb	al
	mov	BYTE PTR _c2, al
	mov	edx, DWORD PTR _x
	mov	eax, DWORD PTR _y
	cmp	edx, eax
	setle	al
	mov	BYTE PTR _c1, al
	mov	edx, DWORD PTR _k1
	mov	eax, DWORD PTR _k2
	cmp	edx, eax
	setb	al
	mov	BYTE PTR _c2, al
	mov	edx, DWORD PTR _x
	mov	eax, DWORD PTR _y
	cmp	edx, eax
	setne	al
	mov	BYTE PTR _c1, al
	mov	eax, DWORD PTR _y
	sal	eax, 3
	mov	DWORD PTR _x, eax
	mov	eax, DWORD PTR _y
	sar	eax, 3
	mov	DWORD PTR _x, eax
	mov	edx, DWORD PTR _y
	mov	eax, DWORD PTR _x
	mov	ecx, eax
	sal	edx, cl
	mov	eax, edx
	mov	DWORD PTR _x, eax
	mov	edx, DWORD PTR _y
	mov	eax, DWORD PTR _x
	mov	ecx, eax
	sar	edx, cl
	mov	eax, edx
	mov	DWORD PTR _x, eax
	mov	eax, 0
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE10:
	.ident	"GCC: (MinGW.org GCC-6.3.0-1) 6.3.0"
