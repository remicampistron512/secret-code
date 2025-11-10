# TP3 — Jeu du Code Secret (console)

## Table des matières

1. [Introduction](#introduction)
2. [Installation](#installation)
3. [Utilisation](#utilisation)
4. [Règles-du-jeu](#règles-du-jeu)
5. [Fonctionnalités](#fonctionnalités)
6. [Structure-du-code](#structure-du-code)

---

## Introduction

Implémentation console d’un **jeu de code secret à 4 chiffres**.
À chaque tentative, le programme indique :

* combien de chiffres sont **bien placés** ;
* combien de chiffres sont **présents mais mal placés**.

Exemple (tiré de l’énoncé) :
secret = `4567`, proposition = `2468` → **1 chiffre bien placé** (6) ; **1 chiffre mal placé** (4).

> Ce README est basé sur le code fourni (`secretCode.java`) et la description « TP3 : Jeu du code secret ».

---

## Installation

**Prérequis** : Java 11+
Fichier source (pas de package) : `secretCode.java`

```bash
javac secretCode.java
java secretCode
```

---

## Utilisation

Au lancement, l’application :

1. demande une proposition : « Rentrez un code de 4 chiffres… » ;
2. valide l’entrée (exactement 4 chiffres) ;
3. calcule et affiche :

    * `n chiffre(s) bien placé(s)` si `n > 0`,
    * `m chiffre(s) mal placé(s)` si `m > 0`.
4. si les **4 chiffres sont bien placés**, affiche le message de **victoire** et termine.

**Secret utilisé par défaut dans le code** : `1246`.

---

## Règles-du-jeu

* Le **code secret** comporte exactement **4 chiffres**.
* Le joueur peut tenter **autant de fois qu’il le souhaite**.
* Après chaque tentative :

    * **bien placé** : même chiffre **à la même position** ;
    * **mal placé** : chiffre présent dans le secret **mais à une autre position**.
* La partie se termine **uniquement** quand les 4 chiffres sont bien placés.

---

## Fonctionnalités

* Lecture **robuste** d’une proposition : exactement 4 caractères numériques (re-saisie sinon).
* Comptage des chiffres :

    * **bien placés** et **mal placés** via la comparaison des tableaux de caractères.
* Message de **victoire** lorsque la proposition égale le secret.

---

## Structure-du-code

* **Classe** : `secretCode` (méthode `main`)

    * `main(String[] args)`

        * boucle de jeu, lecture des propositions, comparaison, affichage des résultats, condition d’arrêt.
    * `fourDigitsInput(Scanner scan) : String`

        * lit et valide une chaîne de **4 chiffres** (demande à ressaisir sinon).
    * `placedOrUnplacedChar(char[] secret, char[] proposed, List<Character> placed, List<Character> unplaced)`

        * remplit `placed` (chiffres **bien placés**) et `unplaced` (chiffres **présents mais mal placés**) en comparant toutes les paires d’indices.

*(Optionnel : renommer la classe en `SecretCode` pour respecter les conventions Java et placer le code dans un package si nécessaire.)*

