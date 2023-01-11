# cadastroApi

Olá, tudo bem com você? Eu sou o João! Sou estudante de programação e estou no meu primeiro ano de técnico.

Tem alguns repositórios meus como estudos direcionados a algumas linguagens de programação e que bom que encontrou este. 👏👏👏

O meu objetivo com estes repositórios é absorver o máximo de conhecimento sobre vários assuntos envolvendo linguagem de programação e tecnologia e da área que eu amo, a de *desenvolvimento de software*. Além disso, poder ajudar quem está estudando também!! 

#### Para saber mais sobre mim, visite:

#### [Linkedin do João](https://www.linkedin.com/in/joaovitorqueiroz/)

#### [Git hub do João](https://github.com/joaovq)


# O que o projeto faz

Usando Spring boot, foi feita API simples para gerenciar Pessoas. 

* Para pular para as requisições: https://github.com/joaovq/cadastroApi/blob/master/README.md#requisi%C3%A7%C3%B5es

Esta API deve permite:   

+ Criar uma pessoa 

+ Editar uma pessoa 

+ Consultar uma pessoa 

+ Listar pessoas 

+ Criar endereço para pessoa 

+ Listar endereços da pessoa 

+ Poder informar qual endereço é o principal da pessoa   


Uma Pessoa deve ter os seguintes campos:   

+ Nome 

+ Data de nascimento 

+ Endereço: 

    - Logradouro 

    - CEP 

    - Número 

    - Cidade 
    
## Para auxiliar na construção do endereço, foi utilizada a API via cep:

O via cep é um Web Service gratuito e de alta qualidade que serve para consultar cep's de todo lugar do Brasil.

Para acessar o webservice, um CEP no formato de 8 dígitos deve ser fornecido.

Foi utilizado no projeto para a validação do cep e segregação de endereços.

+ OBS: no lugar de "Cidade" utilizamos "localidade", tendo o mesmo efeito de cadastro de uma Cidade, neste exemplo.

# Quais ferramentas utilizei neste repositorio?

### Este projeto foi especialmente feito com as seguintes ferramentas:

+ Linguagem Java (jdk 17- zulu);

+ Spring Boot;

+ API [Via Cep](https://viacep.com.br/)

 <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<img src="https://www.codeproject.com/KB/java/Graphic_Context/300px-Java_logo_svg.png"
 width="50px"
 />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwsq-7f5BWyog4cdeT1sQaYLVzhJ0o37Up8TjHvVU08WUgfyyMMRMHTVwJ5XReSjyhZa0&usqp=CAU"
 width="50px"
 /></p>

# Requisições

### Exemplo de requisição GET para pessoas

Na url: http://localhost:8080/pessoas 

### Exemplo de requisição GET por id pessoa

Na url: http://localhost:8080/pessoas/{id}

### Exemplo de requisição GET por enderecos

Na url: http://localhost:8080/enderecos


### Exemplo de requisição GET por id endereco

Na url: http://localhost:8080/enderecos/3

### Exemplo de requisição GET por id endereco principal

Na url: http://localhost:8080/enderecos/pessoa/3/principal

### Exemplo de requisição POST pra pessoa

Na url: http://localhost:8080/pessoas

```Json
{
    "nome": "João",
    "dataDeNascimento": "23/08/1999",
    "endereco": {
        "cep": "40283560",
        "numero": "1"
    }
}

```

### Exemplo de requisição PUT pra pessoa

Na url: http://localhost:8080/pessoas/{id}

```Json
{
    "nome":"João",
    "dataDeNascimento":"05/11/2013",
    "endereco":{
        "cep":"40283565",
        "numero":"94"
    }
}

```

### Exemplo de requisição POST para endereco

Na url: http://localhost:8080/pessoas

+ Necessário passar o id da pessoa para criar um endereco

```Json
{
        "pessoaId":3,
        "cep":"40243560",
        "numero":"839"
    }

```


# Como os Usuários podem usar esse projeto?

## Para clonar esse projeto, faça:  

### 1. **Na página principal do projeto, clique em code:**

![Code](https://user-images.githubusercontent.com/101160670/174395306-b1145b8b-f68e-4cb5-9842-f491224f6c40.PNG)


### 2.  **Copie o link:**

![Clonar](https://user-images.githubusercontent.com/101160670/174395320-7c6b66d2-8195-40d2-b857-8f5a94749213.PNG)



### 3.  **Faça o git clone no Git:**

![git clone](https://user-images.githubusercontent.com/101160670/174393044-ed51c1b3-05a2-4f26-890c-b869774b5420.PNG)





# Onde os Usuários podem obter ajuda no seu projeto

Os Usuários podem enviar uma issue ou um pull request (PR), caso tem algum problema ou enviar uma mensagem para mim no linkedin:

#### [Linkedin do João](https://www.linkedin.com/in/joaovitorqueiroz/)
