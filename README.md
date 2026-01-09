# ViaCepBusca

Aplicação Java simples para consulta de endereços a partir de um CEP brasileiro, utilizando a API pública do **ViaCEP**.

O projeto foi desenvolvido com foco em **boas práticas**, separação de responsabilidades e uso de **Java moderno (Java 17)**.

---

## 🚀 Funcionalidades

- Consulta de endereço por CEP
- Validação e sanitização do CEP
- Consumo de API externa (ViaCEP)
- Conversão de JSON para objetos Java usando **Gson**
- Separação em camadas (`client`, `service`, `domain`, `dto`)

---

## 🧱 Estrutura do Projeto
```text
src/main/java
└── com.joaosevergnini.viacepbusca
├── client
│ └── ViaCepClient.java
├── service
│ └── ViaCepService.java
├── domain
│ └── model
│ └── Address.java
├── dto
│ └── ViaCepResponse.java
└── Main.java
```

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Maven
- Gson
- HTTP Client (java.net.http)
- API ViaCEP

---

## 📦 Dependências

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.12.0</version>
</dependency>
```

---

## 🚴‍♂️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/Joao-Severgnini/ViaCepFinder.git
```
2. Navegue até o diretório do projeto:
```bash
cd ViaCepFinder
```
3. Compile o projeto usando Maven:
```bash
mvn clean install
```
4. Execute a aplicação:
```bash
mvn exec:java
```
(ou execute a classe Main pela IDE)






