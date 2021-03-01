

<div align="center">

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)][home]
[!Github Workflows](https://github.com/mfaisalkhatri/gatlingpoc/actions/workflows/main.yml/badge.svg)

</div>

## :question: What is this Repository about?

- This repo contains example codes for Performance testing using Gatling.
- Rest APIs from https://reqres.in/ have been used for testing.
- Maven is used as a Build Tool.
- Run Time Parameters: `USERS`, `RAMP_DURATION` and `DURATION` are used in the code.
- To run the test from command line use the following command:
- `mvn gatling:test -Dgatling.simulationClass=<Class Name to run test> -DUSERS<No of User> -DRAMP_DURATION<Ramp duration in seconds> -DDURATION<Total test duration in seconds>`

E.g.: `mvn gatling:test -Dgatling.simulationClass=simulations.ReqResEndToEndTests -DUsers=20 -DRAMP_DURATION=10 -DDURATION=30`

🧬 Need Assistance?

- Discuss your queries by writing to me @ [mohammadfaisalkhatri@gmail.com][mail] or you can ping me on the following social media sites:
- Twitter: [mfaisal_khatri][twitter] 
- LinkedIn: [Mohammad Faisal Khatri][linkedin]


## :star2: What you do if you like the project?

- Spread the word with your network.
- **Star** the project to make the project popular.


[mail]: mohammadfaisalkhatri@gmail.com
[linkedin]: https://www.linkedin.com/in/faisalkhatri/
[twitter]: https://twitter.com/mfaisal_khatri
[home]: https://github.com/mfaisalkhatri/gatlingpoc
