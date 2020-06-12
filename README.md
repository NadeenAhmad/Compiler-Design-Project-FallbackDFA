# Compiler-Design-Project-FallbackDFA
* The aim of this project is to implement a fallback deterministic finite automaton with actions
(FDFA) abstract data type.  
Recall that an FDFA is a sextuple (Q, Σ, δ, q0, F, A): 
* Q is a nonempty, finite set of states
* Σ is non-empty, finite set of symbols (an alphabet); δ : Q×Σ −→ Q is the transition function
* q0 ∈ Q is the start state
* F ⊆ Q is the set of accept states
* A is function that maps every state in Q to an action.
• This project is implemented using Java
• Assumptions:  
a) The alphabet Σ is always the binary alphabet {0, 1}.  
b) The set of states Q is always of the form {0, . . ., n}, for some n ∈ N.  
c) The start state is always state 0.  
d) A maps each state to a binary string; the action is to print this string.    
• fdfa (which could be a class constructor) takes one parameter which is a string description of an FDFA and returns (or constructs) an FDFA instance.  
• A string describing an FDFA is of the form P#S, where P is a prefix representing both
the transition function δ and the action function A and S is a suffix representing the set
F of accept state.  
• P is a semicolon-separated sequence of quadruples. Each quadruple is a comma-separated
sequence of items; the first three items are states and the fourth is a binary string. A
quadruple i, j, k, s means that δ(i, 0) = j, δ(i, 1) = k, and A(i) = s.  
• S is a comma-separated sequence of states.  
• Input FDFA: 0,0,1,00;1,2,1,01;2,0,3,10;3,3,3,11#0,1,2  
<img src="https://i.ibb.co/B4dWwgV/fdfa.jpg" width="500" >  
• Running the following string in the previous FDFA 1011100 gives 1000  
