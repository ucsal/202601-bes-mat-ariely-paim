# Atividade SOLID

Refatorar o projeto Sistema de Olimpiadas aplicando os princípios SOLID, mantendo o comportamento funcional original do sistema, sem remoção de funcionalidades e sem uso de frameworks externos.

---

## Mudanças realizadas

- Antes da refatoração, todas as classes estavam na mesma pasta 'main'. Por isso foi necessário a criação das pastas 'model', 'repository', 'service' e 'ui'. Dessa forma, também foi preciso mover todas as classes das entidades (Participante, Prova, Questao, Resposta, Tentativa) para dentro da pasta 'model'. 
- Antes da refatoração, as operações de cadastrar, listar e aplicar provas estavam concentradas ou altamente dependentes umas das outras. Por isso foi necessário a criação da pasta Repository concentrando as classes responsáveis pelo armazenamento e acesso aos dados (ParticipanteRepository, ProvaRepository, QuestaoRepository, TentativaRepository), substituindo as listas que estavam no App.java anteriormente.
- Antes da refatoração, a lógica ficava toda na classe App. Por isso foi necessário a criação da pasta Service concentrando as classes responsáveis pelas regras de negócio (ParticipanteService, ProvaService, QuestaoService, TentativaService), movendo as validações e lógicas que estavam no App.java anteriormente.
- Antes da refatoração, a interação com o usuário ficava na classe App. Por isso foi necessário a criação da pasta Ui concentrando a classe responsável por gerenciar o ciclo de vida da aplicação, já que o ConsoleMenu.java garante que o programa não feche após uma única operação e que o usuário possa navegar entre as funcionalidades de forma organizada.
---

## Aonde os príncipios SOLID foram aplicados?
Os cinco pilares do SOLID foram aplicados da seguinte forma:

1. S – Single Responsibility Principle (SRP):
Em vez de uma classe gerenciar todo o fluxo da olimpíada, foram criadas classes especialistas para gerenciar cada uma a sua funcionalidade primária.

2. O – Open/Closed Principle (OCP):
A classe Menu foi projetada para receber uma lista de OpcaoMenu. Então se precisar adicionar uma nova funcionalidade, é só criar uma nova classe que implementa essa ação e a adiciona ao menu, sem precisar mexer no código interno da classe Menu ou nos outros serviços já existentes.

3. L – Liskov Substitution Principle (LSP):
Ao utilizar interfaces para os repositórios (como ParticipanteRepository), o sistema garante que qualquer implementação dessa interface (seja em memória, banco de dados ou arquivo) funcione perfeitamente quando injetada nos serviços, mantendo o comportamento esperado.

4. I – Interface Segregation Principle (ISP):
Houve uma separação clara entre os serviços. Um serviço que apenas lista tentativas não precisa conhecer métodos de cadastro de questões. As interfaces de repositório e serviços foram mantidas coesas e específicas para suas finalidades.

5. D – Dependency Inversion Principle (DIP):
No código inicial, a classe App criava e controlava tudo diretamente. Após a refatoração, ela fica responsável somente por instanciar as dependências e injetá-las.
---