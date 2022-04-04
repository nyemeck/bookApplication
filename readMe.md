# Small basic project to fetch data from Goole Book API

_Libraries used_
1. Hilt for dependency injection
2. Room for database
3. Glide to load images


_App folder architecture_
1. Folder presentation: Contains all the components related to the UI (Activities, Adapters, viewModel)
2. Folder network: contains the services resposible to build the server request and network models to send or fetch from the server
3. Folder database: create the database and make it available 
4. Folder repository: contains classes resposible to build the repository partern and make available the service and the database
5. Folder di: provide repository, the service instance and the database instance inside the App
