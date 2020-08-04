[![build](https://github.com/githubslayer/pig-latin-translator/workflows/build/badge.svg?branch=master&event=push)](https://github.com/githubslayer/pig-latin-translator/actions?query=workflow%3Abuild)  [![codecov](https://codecov.io/gh/githubslayer/pig-latin-translator/branch/master/graph/badge.svg?token=R6MCBWXP1S)](https://codecov.io/gh/githubslayer/pig-latin-translator) [![GitHub](https://img.shields.io/github/license/githubslayer/pig-latin-translator)](https://github.com/githubslayer/pig-latin-translator/blob/master/LICENSE)


# Pig Latin Translator
## Overview
* Write some Java code that translates a string (word, sentence, or paragraph) into “pig-latin” using the following rules.
	* Words that start with a consonant have their first letter moved to the end of the word and the letters “ay” added to the end.
		* **Hello** becomes **Ellohay**
	* Words that start with a vowel have the letters “way” added to the end.
		* **apple** becomes **appleway**
	* Words that end in “way” are not modified.
		* **stairway** stays as **stairway**
	* Punctuation must remain in the same relative place from the end of the word.
		* **can’t** becomes **antca’y**
		* **end.** becomes **endway.**
	* Hyphens are treated as two words
		* **this-thing** becomes **histay-hingtay**
	* Capitalization must remain in the same place.
		* **Beach** becomes **Eachbay**
		* **McCloud** becomes **CcLoudmay**

## Requirement
* Java 11
	 
## Quick start
### Build
```
$ mvn clean install
```
### Run
```
$ cd pig-latin-translator-app
$ mvn exec:java
```
