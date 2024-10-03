# Blackjack

## Introdução

Este repositório contém o código-fonte do projeto **Blackjack (21)**, desenvolvido como parte da disciplina **PI: Desenvolvimento de Sistemas Orientados a Objetos** do quarto semestre do curso de **Engenharia da Computação** na **PUC-Campinas**. O projeto visa aplicar conceitos de programação orientada a objetos (POO) no desenvolvimento de um jogo interativo de cartas.

## O Jogo

O **Blackjack** é um jogo de cartas popular em cassinos, cujo objetivo é atingir a pontuação mais próxima de 21 sem ultrapassá-la, competindo contra o dealer.

### Regras Básicas
- Cada jogador recebe inicialmente duas cartas, e o dealer também.
- O jogador pode optar por "pedir" cartas adicionais ou "parar" com as cartas que tem.
- O objetivo é ter uma mão de cartas com valor total mais próximo de 21, mas sem ultrapassá-lo.

### Valores das Cartas
- O **Ás** pode valer 1 ou 11 pontos, dependendo da situação.
- As figuras **J**, **Q** e **K** valem 10 pontos cada.
- As demais cartas possuem seu próprio valor numérico.
- Os **naipes** não têm impacto na pontuação.

## Estrutura do Projeto

O projeto foi desenvolvido em **Java**, utilizando os conceitos de POO. As principais classes incluem:
- **DeckOfCards**: Representa o deck, gerando e embaralhando as cartas.
- **Card**: Representa uma carta com valor e naipe.
- **Hand**: Representa a mão do jogador.
- **Dealer**: Representa o dealer, também representa a classe pai do Player.
- **Player**: Representa o jogador, herda o dealer.
- **Dealer**: Similar ao jogador, mas segue regras específicas para o Blackjack.
- **Game**: Controla o fluxo do jogo, incluindo a lógica para definir vencedores e realizar novas rodadas.
- **DeckOfCardsTest**: Arquivo principal.

## Contribuições

Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias, sugestões ou correções de bugs!