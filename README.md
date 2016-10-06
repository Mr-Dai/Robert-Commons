# Robert-Commons
Java common util classes of my own

## Deploy

Create (or modified) `gradle.properties` and add the following:

```
releaseDeployUrl=<link-to-maven-release-repo>
snapshotDeployUrl=<link-to-maven-snapshot-repo>
deployUsername=<maven-repo-username>
deployPassword=<maven-repo-password>
```

Then execute:

```
gradlew upload
```
