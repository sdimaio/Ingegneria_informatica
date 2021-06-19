_EXIT = 1
_PRINT = 127
_SECT .TEXT
start:
    PUSH stringa
    MOV BX, end
    CALL LUN
    MOV SP,BP
    PUSH BX
    PUSH stampa1
    PUSH _PRINT
    SYS

    MOV SP,BP
    PUSH (x)  !devo passara il carattere e non l'indirizzo
    PUSH stringa
    CALL OCC
    MOV SP,BP
    PUSH DX
    PUSH stampa2
    PUSH _PRINT
    SYS

    MOV SP,BP
    PUSH 0
    PUSH _EXIT
    SYS



LUN:
    PUSH BP
    MOV BP,SP
    MOV AX,4(BP)
    SUB BX,AX
    MOV SP,BP
    POP BP
    RET

OCC:
    PUSH BP
    MOV BP,SP

    MOV DI,4(BP) !stringa
    MOVB AL,6(BP) !carattere x
    MOV CX,BX    !salvo la lunghezza della stringa in CX
    MOV DX,0

1:  SCASB
    JNE 2f
    INC DX
2:  LOOP 1b

    MOV PS,BP
    POP BP
    RET

_SECT .DATA
stringa: .ASCII "stringa"
x: .ASCII "i"
end: .SPACE 1
spampa1: .ASCIZ "La lunghezza della stringa e' %d\n"
spampa2: .ASCIZ "Ci sono %d caratteri : i"
_SECT .BSS
