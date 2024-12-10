# Lab One

- creating a text formatter for a text editor
- a text editor can have different text formatters
- so we will have a bunch of text formatters and pass the required one

  - to the text editor in order to formate a text

- Using the `Strategy Design Pattern`

  - A family of algorithms encapsulating one another
  - Keep the implementations of each of the algorithms in a separate class (Strategy)
  - any object using the strategy object - called - context object
  - strategy objects must be designed to offer the same interface
  - what a client needs to do is to configure the context, with the selected strategy instance
  - what do we have
    - `Strategy`:
      - declares the interface common to all supported algorithms
      - note that `context` will use this interface to call the algorithm defined by the `concrete strategy`
    - `Concrete Strategy`:
      - implements the algorithm using the `strategy` interface
    - `Context`:
      - congfigured with a `concrete strategy` object
      - maintains a reference to the `strategy` object
      - may define an interface that lets `strategy` access its data

- [](./src/main/java/frank/labone/)
