<p align="center">
<img src="https://www.svgrepo.com/show/323895/nautilus-shell.svg" width=120 height=120 />
</p>

# Nautillus: Sistema de Gestão de Lotes de Medicamentos

Projeto interdisciplinar desenvolvido por alunos da ETEC Bento Quirino, Campinas/SP.

O projeto visa facilitar o gerenciamento de lotes de medicamentos e consulta de estoque.

---

## Este repositório

Contém apenas o **back-end** e o **front-end** da aplicação.

O sistema embarcado estará hospedado em repositório separado.

Estrutura de pastas:

```
src/
  main/.../
      enums/           # Enums de classes
      models/          # Modelo de classes
      Main.java        # Main
  test/
    java/.../testes    # Testes com o JUnit
pom.xml
```

---

## Back-end

- Linguagem: Java
- Gerenciador de dependências: Maven


### Como executar

```bash
# Compilar
mvn compile

# Executar testes
mvn test

# Gerar build
mvn package
```

---

## Observações

- A API ainda está em desenvolvimento e não possui endpoints funcionais neste momento.
