# Guia do Desenvolvedor

#### Padrão de código

Todo código produzido deve ser documentado e testado. 


#### Escrevendo Menssagens de Commit

Um commit ideal deve ser atômico, descrever apenas uma alteração lógica.


#### Por que bons commits são necessários?


Um commit atômico é mais fácil de revisar. Também é mais fácil de o revisador achar
bugs devido a baixa complexidade da mudança.
Boas mensagens de commit facilitam saber o que aconteceu num determinado espaço de
tempo.
É mais fácil reverter mudanças atômicas sem que haja efietos colaterais.

#### Como escrever boas mensagens de commit?

Uma boa mensagem consiste em 3 partes:
* shortlog
* corpo do commit
* referência à issue ou task

Exemplo:

Aluno.java: Criação de construtor para aluno

Adicionado o contrutor, juntamente com as validações de cada atributo do aluno

fix #112

#### Shotlog

Exemplo:

Aluno.java: Criação de construtor para aluno

Máximo de 50 caracteres.
Manter a linha desse tamanho garante que o shortlog explica a mudança de forma concisa
Deve descrever a mudança/ação fetia no commit.

Deve ter uma tag e uma descrição curta separada por dois pontos (:)


1.1 Tag


Arquivo, classe ou pacote sendo modificado.


1.2 Descrição


Começa com letra maiúscula
Escrita no presente imperativo ex. (Adiciona classe aluno, não Adicionada
classe aluno ou classe aluno adicionada).


#### Corpo do commit

Exemplo:

Adicionado o contrutor, juntamente com as validações de cada atributo do aluno.

Maximo de 72 caracteres.
Não é obrigatório, mas ajuda a explicar suas alterações.
Deve descrever seu raciocínio. Isso é especialmente importante em casos em que mudanças complexas são feitas. Também é o local correto para escrever sobre bugs relacionados.
Não deve ser escrito em primeira pessoa.



#### Referência à Issue ou Task

Exemplo:

fix #112

Deve usar algumas das keys definidas na tabela abaixo.
Deve usar a a numeração da issue ou task
Deve haver um único espaço entre a key e a numeração

| keys         | Descrição                                                                                               |
| -------------|---------------------------------------------------------------------------------------------------------|
| **feat**     | Uma nova feature.                                                                                       |
| **fix**      | Uma correção de um bug.                                                                                 |
| **style**    | Mudanças que não afetam o significado do código (espaços em branco, formatação, pontos-e-virgulas, etc).|
| **refactor** | Uma mudança no código que corrige um bug ou adiciona um novo recurso.                                   |
| **test**     | Adição de testes                                                                                        |



Este guia usa os padrões definidos no projeto Coala https://api.coala.io/en/latest/Developers/Writing_Good_Commits.html
