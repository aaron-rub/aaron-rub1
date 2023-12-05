```java
package com.nighthawk.spring_portfolio.mvc.shoes;

public @interface Getmapping {

    String value();

}
```

```java
package com.nighthawk.spring_portfolio.mvc.shoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.time.LocalDate;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String name;

    private int price;
、
    private LocalDate date;
    // starting shoes
    public static String[] init() {
        final String[] shoesArray = {
        };
        return shoesArray;
    }
}
```

```java
package com.nighthawk.spring_portfolio.mvc.shoes;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/shoes")  // all requests in file begin with this URI
public class ShoesApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private ShoesJpaRepository repository;

    /* GET List of Jokes
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Jokes>> getJokes() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    /* Update Like
     * @PutMapping annotation is used for mapping HTTP PUT requests onto specific handler methods.
     * @PathVariable annotation extracts the templated part {id}, from the URI
     */
    @Getmapping("/name")
    public ResponseEntity<Jokes> getName(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Shoes names = repository.findAll()
        int i, j;
        Shoes key;
        for (i = 1; i < n; i++) {
            key = names[i];
            j = i - 1;
    
            while (j >= 0 && names[j].name > key.name) {
                names[j + 1] = names[j];
                j = j - 1;
            }
            names[j + 1] = key;
        return names;
    }

    @GetMapping("/price")
    public ResponseEntity<Jokes> getName(@PathVariable long id) {
        Shoes price = repository.findAll()
        int i, j;
        Shoes temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (price[j].price > price[j + 1].price) {
                    temp = price[j];
                    price[j] = price[j + 1];
                    price[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }
}
```
```java
package com.nighthawk.spring_portfolio.mvc.shoes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA is an object-relational mapping (ORM) to persistent data, originally relational databases (SQL). Today JPA implementations has been extended for NoSQL.
public interface ShoesJpaRepository extends JpaRepository<Jokes, Long> {
    /* JPA has many built in methods: https://www.tutorialspoint.com/spring_boot_jpa/spring_boot_jpa_repository_methods.htm
    The below custom methods are prototyped for this application
    */
    void save(String Joke);
    List<Jokes> findAllByOrderByJokeAsc();
    List<Jokes> findByJokeIgnoreCase(String joke);
}

```

```html
<!DOCTYPE html>
<html>
<head>
    <title>Shoe Store</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Shoe Store!</h1>
    <p>Here you can find information about our shoes.</p>
    <table id="shoeTable">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Date</th>
        </tr>
        <!-- Shoe data will be inserted here -->
    </table>
    <script>
        // Fetch the shoe data from your API and populate the table
        fetch('/api/shoes')
            .then(response => response.json())
            .then(data => {
                const table = document.getElementById('shoeTable');
                data.forEach(shoe => {
                    const row = table.insertRow();
                    row.insertCell().textContent = shoe.name;
                    row.insertCell().textContent = shoe.price;
                    row.insertCell().textContent = shoe.date;
                });
            });
    </script>
</body>
</html>
```
