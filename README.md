
Checklist for QA coding task:
1. Only one user should be found for username Delphine
2. At least one post should be found for username Delphine
3. At least one comment should be found for each Post for username Delphine
4. Each comment has a correct format Email

App requirements for running tests:
1.Maven (any version)
2. OpenJDK 64-Bit Server VM (build 13.0.1+9
3. Git

Run tests:
1. Checkout repository: Git clone https://github.com/AntonKa0123/coding_task
2. checkout main branch: git checkout main
3. Run in project directory: mvn clean test
4. For analysing test results run: mvn allure:report


CircleCI jobs: https://app.circleci.com/pipelines/github/AntonKa0123/coding_task
