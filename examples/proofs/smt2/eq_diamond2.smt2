(set .c1 (input :conclusion (#1:(and #2:(or #3:(and #4:(= y0 x0) #5:(= y0 x1)) #6:(and #7:(= z0 x0) #8:(= z0 x1))) (not #9:(= x1 x0))))))
(set .c2 (and :clauses (.c1) :conclusion (#2)))
(set .c3 (and_pos :conclusion ((not #3) #4)))
(set .c4 (and_pos :conclusion ((not #3) #5)))
(set .c5 (and_pos :conclusion ((not #6) #7)))
(set .c6 (and_pos :conclusion ((not #6) #8)))
(set .c7 (or :clauses (.c2) :conclusion (#3 #6)))
(set .c8 (and :clauses (.c1) :conclusion ((not #9))))
(set .c9 (eq_transitive :conclusion ((not #8) (not #7) #9)))
(set .c10 (resolution :clauses (.c9 .c8) :conclusion ((not #8) (not #7))))
(set .c11 (resolution :clauses (.c10 .c6 .c5) :conclusion ((not #6))))
(set .c12 (resolution :clauses (.c7 .c11) :conclusion (#3)))
(set .c13 (resolution :clauses (.c3 .c12) :conclusion (#4)))
(set .c14 (resolution :clauses (.c4 .c12) :conclusion (#5)))
(set .c15 (eq_transitive :conclusion ((not #5) (not #4) #9)))
(set .c16 (resolution :clauses (.c15 .c13 .c14 .c8) :conclusion ()))