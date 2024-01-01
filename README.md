# Git log

## Introduction
This simple Spring Boot application is designed to retrieve logs from the Git repositories.

## Future improvements

- Implementing a better way of connecting to the repository. Currently, the application downloads the whole repository which is very ineffective for large repositories with constant updates. Therefore it is more optimal to use Rest API of Github.
- Adding support for private repositories.
- Handling updates of the remote repositories
