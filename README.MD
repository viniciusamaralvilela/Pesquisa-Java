# README – Explicação Completa do Código + Como abrir tabela no CMD

---

## 🧠 **1. Explicação completa do código (Maven + Hibernate + Classes)**

### **1.1 `pom.xml` – O que significa cada parte**

* **`<groupId>` e `<artifactId>`**: identificam seu projeto Maven.
* **`<dependencies>`**: tudo que seu projeto precisa para funcionar.

  * **Hibernate**: faz o mapeamento objeto-relacional (ORM).
  * **MySQL Connector**: permite conectar no MySQL.
  * **JPA API**: padrão oficial de regras que o Hibernate segue.
* **Propriedades (`<properties>`)**: definem versão do Java e do Hibernate.

---

### **1.2 Arquivo `hibernate.cfg.xml`**

* **`hibernate.connection.url`**: endereço do MySQL e do banco.
* **`username` / `password`**: login e senha do banco.
* **`driver_class`**: driver necessário para conectar.
* **`dialect`**: adapta o Hibernate para comandos SQL do MySQL.
* **`hbm2ddl.auto = update`**: cria/atualiza tabelas automaticamente.
* **`mapping class="com.example.Usuario"`**: diz qual classe vira tabela.

---

### **1.3 Classe `Usuario`**

* `@Entity`: indica que vira uma tabela no banco.
* `@Table(name="usuarios")`: nome da tabela gerada.
* `@Id`: identifica a chave primária.
* `@GeneratedValue`: gera IDs automaticamente.
* Campos `nome` e `idade` viram colunas.

---

### **1.4 Classe `HibernateUtil`**

* Lê o arquivo de configuração.
* Cria a **SessionFactory**, usada para abrir conexões com o banco.

---

### **1.5 Classe `Main`**

Fluxo:

1. Lê nome e idade do usuário.
2. Cria um objeto `Usuario`.
3. Abre uma sessão Hibernate.
4. Inicia uma transação.
5. Salva o usuário no banco com `persist()`.
6. Dá commit.
7. Fecha a sessão.
8. Mostra mensagem de sucesso.

---

## 🔐 **2. Como abrir o banco e visualizar a tabela pelo CMD**

### **2.1 Entrar no MySQL**

```
mysql -u root -p
```

### **2.2 Listar todos os bancos**

```
SHOW DATABASES;
```

### **2.3 Entrar no banco criado pelo Hibernate**

```
USE teste_hibernate;
```

### **2.4 Listar tabelas do banco**

```
SHOW TABLES;
```

### **2.5 Ver a estrutura da tabela**

```
DESCRIBE usuarios;
```

### **2.6 Mostrar os dados salvos**

```
SELECT * FROM usuarios;
```

### **2.7 Sair do MySQL**

```
exit;
```
