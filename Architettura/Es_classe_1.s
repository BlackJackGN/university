getmax:
    lw x5,0(x10)

loop:
    beq x11,zero,end_loop
    lw x6,0(x10)
    bge x5,x6,no_change #se non salta
    add x5,x6,zero  #nuovo max
    j loop

no_change:
    addi x11,x11,-1
    add x10,x10,4
    j loop

end_loop:
    add x12,x5,zero
    ret
