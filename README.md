# Conversor de Moedas - Back-End Java

Este projeto é um **Conversor de Moedas** construído em Java, desenvolvido para consolidar conhecimentos em Programação Orientada a Objetos e consumo de APIs RESTful. O sistema interage com o usuário via console, oferecendo diversas opções de conversão de moedas em tempo real.

## 🎯 Objetivo do Projeto
O principal objetivo foi construir um programa capaz de realizar requisições HTTP para uma API externa de taxas de câmbio, manipular os dados recebidos no formato JSON e entregar ao usuário a conversão exata entre moedas como Dólar (USD), Real (BRL), Euro (EUR) e Peso Argentino (ARS).

## 🛠️ Tecnologias e Bibliotecas Utilizadas
* **Java:** Linguagem principal do projeto.
* **HttpClient, HttpRequest, HttpResponse:** Classes nativas do Java utilizadas para realizar as chamadas de rede.
* **Gson (Google):** Biblioteca utilizada para a desserialização do arquivo JSON retornado pela API para objetos (Records) no Java.
* **ExchangeRate-API:** API externa gratuita utilizada para obter as taxas de câmbio atualizadas em tempo real.

## ⚙️ Funcionalidades
- Menu interativo via console para escolha das moedas de origem e destino.
- Tratamento de exceções para garantir que o programa não quebre caso o usuário digite letras ao invés de números.
- Requisições dinâmicas construídas com base na escolha do usuário.
- Cálculos precisos utilizando as taxas de câmbio extraídas da API.

## 🚀 Como executar este projeto

Caso queira executar este projeto no terminal (linha de comando), certifique-se de ter o arquivo `gson-2.10.1.jar` no mesmo diretório dos seus arquivos `.java`.

1. **Compile os arquivos Java incluindo a biblioteca Gson:**
   ```bash
   javac -cp gson-2.10.1.jar *.java

2. Execute o programa:
Bash
java -cp ".:gson-2.10.1.jar" Principal
(Nota: Se estiver usando o Windows, substitua o separador .: por .;)

👩‍💻 Autoria
Desenvolvido por Ana Bárbara como parte da jornada de especialização em Back-End e Java.