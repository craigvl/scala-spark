## Option

```
def f(x: Int): Option[Int] = if (x == 0) None else Some(x)

f(0) // None
f(1) // Some(2)

```

## Default value

Pattern matching
```
  match {
    case 100 => "One hundred"
    case _ => "Unknown value" 
  }
```

Initial Class Generic Value
```
class Default[A] {
  val a: A = _
}
```


## Futures [TODO]

## Data types

![types](https://i.stack.imgur.com/2fjoA.png)
