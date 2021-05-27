The source code for my personal website, hosted at https://alexvanyo.github.io.

The website is written almost exclusively in Kotlin, using [Compose for Web](https://compose-web.ui.pages.jetbrains.team/) for the interface.

The backing data is pulled from Medium's RSS feed using a Kotlin application, and stored in source control as a JSON file, using shared models to serialize and deserialize on the website.

Data updates and website deployments are both done automatically using GitHub Actions.
