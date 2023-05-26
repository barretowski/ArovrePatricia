# ArvorePatricia
![image](https://github.com/barretowski/ArvorePatricia/assets/69700545/c9591881-3646-4c13-aa3e-5a61029a21d4)

A árvore Patricia é construída a partir da árvore binária de 
prefixo. Seja um conjunto de chaves {s1
, …, sn
} de valores 
binários tais que nenhuma chave seja prefixo de outra. As 
chaves válidas se encontram nas folhas da árvore. Admita, 
inicialmente, que a chave procurada x seja sempre válida. 
Suponha, agora, que se deseja buscar a chave x = s4 na 
árvore. A partir do valor binário de x, o algoritmo 
percorrerá o caminho 11100 na árvore, iniciando pela raiz. 
Observe que esse caminho (figura anterior) contém o 
zigue-zague formado pelos vértices v1
, v2
assinalados.
• A ideia, seria colocar uma informação (rótulo) no nó 
correspondente ao segundo dígito da chave 11100 para 
que a busca prosseguisse para o quinto dígito. Isso 
corresponde a eliminar o zigue-zague. A árvore Patricia é 
obtida dessa forma

## Trabalho ##
-> Inserção das palavras na arvore
