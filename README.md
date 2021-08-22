# Aprendendo Scala

[![License][license-badge]][license-url]

> Aprendendo Scala é meu repositório de estudos desta linguagem muito usada em Engenharia de Dados.

Para informações mais detalhadas acesso o site da linguagem em https://scala-lang.org.

## O que é Scala?

Scala é uma linguagem de programação multiparadigma moderna projetada para expressar padrões de programação comuns de maneira concisa, elegante e segura. Ele integra perfeitamente recursos de linguagens orientadas a objetos e funcionais.

## Scala é orientado a objetos

Scala é uma linguagem puramente orientada a objetos, no sentido de que todo valor é um objeto. Tipos e comportamentos de objetos são descritos por classes e [traits](https://docs.scala-lang.org/tour/traits.html). As classes podem ser estendidas por subclasses e usando um mecanismo de composição flexível baseado em [mixin](https://docs.scala-lang.org/tour/mixin-class-composition.html) como um substituto limpo para herança múltipla.

## Scala é funcional

Scala também é uma linguagem funcional no sentido de que cada função é um valor. Scala fornece uma sintaxe leve para definir funções anônimas, suporta funções de ordem superior, permite que funções sejam aninhadas e suporta [currying](https://docs.scala-lang.org/tour/multiple-parameter-lists.html). As classes de caso do Scala e seu suporte integrado para correspondência de padrões fornecem a funcionalidade de tipos algébricos, que são usados ​​em muitas linguagens funcionais. Objetos *singleton* fornecem uma maneira conveniente de agrupar funções que não são membros de uma classe.

Além disso, a noção de correspondência de padrões de Scala naturalmente se estende ao processamento de dados XML com a ajuda de ignorar corretamente os padrões de sequência, por meio de extensão geral por meio de objetos extratores. Neste contexto, as [comprehensions](https://docs.scala-lang.org/tour/for-comprehensions.html) são úteis para a formulação de consultas. Esses recursos tornam o Scala ideal para o desenvolvimento de aplicativos como *web services*.

## Scala tem tipagem estática

O sistema de tipos expressivos do Scala impõe, em tempo de compilação, que as abstrações sejam usadas de maneira segura e coerente. Em particular, o sistema de tipos suporta:

* Classes genéricas
* Anotações de variância
* Limites de tipo superior e inferior
* Classes internas e membros de tipo abstrato como membros de objeto
* Tipos compostos
* Referências próprias digitadas explicitamente
* Parâmetros e conversões implícitas
* Métodos polimórficos

A inferência de tipo significa que o usuário não é obrigado a anotar o código com informações de tipo redundantes. Em combinação, esses recursos fornecem uma base poderosa para a reutilização segura de abstrações de programação e para a extensão de software com segurança de tipo.

## Scala é extensível

Na prática, o desenvolvimento de aplicativos específicos de domínio geralmente requer extensões de linguagem específicas de domínio. Scala fornece uma combinação única de mecanismos de linguagem que torna simples adicionar novas construções de linguagem na forma de bibliotecas.

Em muitos casos, isso pode ser feito sem o uso de recursos de metaprogramação, como macros. Por exemplo:

* As classes implícitas permitem adicionar métodos de extensão aos tipos existentes.
* A interpolação de string é extensível pelo usuário com interpoladores personalizados.

## Scala interopera

Scala foi projetado para interoperar bem com o popular *Java Runtime Environment (JRE)*. Em particular, a interação com a linguagem de programação Java orientada a objetos é tão perfeita quanto possível. Recursos Java mais recentes como SAMs, [lambdas](https://docs.scala-lang.org/tour/higher-order-functions.html|lambdas), [annotations](https://docs.scala-lang.org/tour/annotations.html|annotations) e [generics](https://docs.scala-lang.org/tour/generic-classes.html|generics) têm análogos diretos no Scala.

Esses recursos do Scala sem análogos do Java, como parâmetros padrão e nomeados, compilam o mais próximo possível do Java quanto razoavelmente possível. Scala tem o mesmo modelo de compilação (compilação separada, carregamento dinâmico de classe) que Java e permite acesso a milhares de bibliotecas de alta qualidade existentes.

Vejamos um comparativo em termos de recursos do que pode ser representado diretamente em bytecode na JVM entre uma classe Java bem simples e uma classe equivalente em Scala.

```java
public class Foto {
  private final String id;
  private final String owner;

  public Foto(String id, String owner) {
    this.id = id;
    this.owner = owner;
  }

  public String getId() {
    return id;
  }

  public String getOwner() {
    return owner;
  }
}
```
Usaremos o comando javap para examinar a estrutura do código compilado:

```bash
$ javac Foto.java
$ javap -p Foto
Compiled from "Foto.java"
public class Foto {
  private final java.lang.String id;
  private final java.lang.String owner;
  public Foto(java.lang.String, java.lang.String);
  public java.lang.String getId();
  public java.lang.String getOwner();
}
```

Conforme mencionado acima vamos fazer o equivalente com uma classe Scala.

```scala
class Foto(val id: String, val owner: String)
```

```bash
$ scalac Foto.scala
$ javap -p Foto
Compiled from "Foto.scala"
public class Foto {
  private final java.lang.String id;
  private final java.lang.String owner;
  public java.lang.String id();
  public java.lang.String owner();
  public Foto(java.lang.String, java.lang.String);
}
```
Aqui podemos perceber uma das vantagens da linguagem Scala, com muito menos esforço podemos criar um script equivalente e que gera um bytecode praticamente igual.

> Você pode experimentar Scala sem precisar instalar em seu computador, acesse https://scastie.scala-lang.org.

## Um pouco de história

A linguagem Scala foi criada por Martin Odersky, na [EPFL](https://www.epfl.ch) (École Polytechnique Fédérale de Lausanne), na Suíça e significa *Scalable Language*. 

Odersky trabalhou em diversas linguagens e compiladores, entre eles o próprio javac, e no Java Generics. Além das experiências anteriores, dois outros projetos liderados por Odersky influenciaram a criação do Scala: a linguagem [Funnel](http://lampwww.epfl.ch/funnel/), uma linguagem funcional altamente acadêmica e implementada em Java e [Pizza](http://pizzacompiler.sourceforge.net/), uma extensão para a linguagem Java que adicionava, entre outras coisas, Programação Funcional.

Como muitos projetos de pesquisa, Scala começou sendo pouco adequado para ambientes de produção, tendo um foco mais acadêmico. Mas isso mudou muito desde a versão 2 da linguagem e, em especial, desde que o Twitter começou a adotar a linguagem, em 2007.

Ser desenvolvida por uma equipe de pesquisa poderia ser uma desvantagem em alguns cenários. Para resolver esse problema, e melhorar o ciclo de evolução da linguagem Scala, Martin Oderky e Jonas Bonér criaram a Typesafe, que mais tarde foi renomeada para [Lightbend](https://www.lightbend.com/). Ela é uma empresa que recebeu investimentos do mercado financeiro e hoje é responsável por garantir o futuro da linguagem Scala e alguns frameworks importantes, como o [Akka](https://akka.io) e o [Play Framework](https://www.playframework.com).

#### License
[MIT](https://github.com/dirleif/entendendo-docker-e-docker-compose/blob/main/LICENSE)

#### Fontes:

<https://scala-lang.org/>

<https://docs.scala-lang.org>

<https://scastie.scala-lang.org>

<https://www.scala-lang.org/api/current/>

<https://www.casadocodigo.com.br/pages/sumario-scala>


[license-badge]: https://img.shields.io/github/license/dirleif/entendendo-docker-e-docker-compose
[license-url]: https://opensource.org/licenses/MIT