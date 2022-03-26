#Cascading
### 1. Cascading é o processo de propagação de não-select operations como: insert, delete e update do objeto Main em associação com o objeto filho.
### 2. Nós podemos controlar como a propagação acontece e em que nível e sobre que operações usar o elemento Cascade no relacionamento @ManyToOne -> @OneToMany
### 3. (Cascade = "Persist") Ele pega vários diferentes valores por cascata e insere a operação sobre o Main Objeto (super-classe) que deveria ser propagado para o objeto filho(sub-classe).
### 4. (Cascade = "merge") Cascade é igual a mesclar e inserir ou uma operação update sobre o Main Object que deveria ser propagado para o objeto filho(sub-classe).
### 5. (Cascade = "remove") Se uma Clase mãe sofre um delete, automaticamente o objeto filho também sofrerá um delete
### 6. (Cascade = "refresh") segue o mesmo fluxo dos demais acima: mãe e filho.
### 7. (Cascade = "detach")
### 8. (Cascade = "all") Todos os efeitos em cascata que o Pai sofrer, o Filho também sofrerá.
### 9. Todos eles podem ser aplicados para uma associação e dependendo do que seja, pode aplicá-los para controlar o efeito cascata (cascading)
### 10. Basicamente, o efeito cascata está relacionado a: "Todos os efeitos em cascata que o Pai sofrer, o Filho também sofrerá de acordo com algum tipo de non-select operations acima.
