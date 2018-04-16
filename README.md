# 2018-power-up
Competition code is found in project `Carbi`.

If in doubt, go to [screensteps live](http://wpilib.screenstepslive.com/s/currentCS).

**Useful screensteps references:**  
[Control system hardware review](http://wpilib.screenstepslive.com/s/currentCS/m/getting_started/l/599672-frc-control-system-hardware-overview)  
[Setting up the development environment](http://wpilib.screenstepslive.com/s/currentCS/m/java/c/88899)  

**Talon SRX References:**  
[Talon SRX Technical Resources](http://www.ctr-electronics.com/talon-srx.html#product_tabs_technical_resources)  
[Software Reference Manual](https://github.com/CrossTheRoadElec/Phoenix-Documentation/raw/master/Talon%20SRX%20Victor%20SPX%20-%20Software%20Reference%20Manual.pdf) \(Found under `FRC FIRST POWERUP Software API` section\)  
Also in the same section are `.CRF` files for updating firmware, Java API documentation, and other useful documents.

## Branches
The main branch `master` is for **competition code only**. Any changes should be made in their own branch based off `master` so if something goes horribly wrong, the branch can be reverted and the code in `master` is preserved. If there is finalized code in a development branch, open a pull request so it can be merged into `master`. Only `cyamonide` (Simon) or `suchaHassle` (Jason) will be accepting these.

## To-do and issues
See issues tab for what needs to be done next with the projects. If you plan on taking care of one of the items on the list, please assign yourself to the issue, and reply with your intent to work on it, and also the branch that you will be contributing to. Any questions should also be stated in reply to the issue; they will be answered as soon as possible.

## If you're new to GitHub and Git:
For most people, a GUI is easiest to use. Watch this [video](https://www.youtube.com/watch?v=BKr8lbx3uFY) in this [playlist](https://www.youtube.com/watch?v=1h9_cB9mPT8&list=PLqGj3iMvMa4LFz8DZ0t-89twnelpT4Ilw) to learn how to use it.  
If you don't mind using a command line, watch everything in this great tutorial by The Net Ninja, found [here](https://www.youtube.com/watch?v=3RjQznt-8kE&list=PL4cUxeGkcC9goXbgTDQ0n_4TBzOO0ocPR).

## Before you commit:
* Learn how to write good commit messages and maintain the integrity of this repository by reading [this useful guide](https://chris.beams.io/posts/git-commit/) by Chris Beams.  
* Do not commit more than one change. Instead, each commit should be representative of a single change.  
* Code should work at every commit so that if anything needs to be reverted, we won't have everything broken.  
* If you're in the nine out of ten times where the code doesn't work, elaborate in the body of the commit message.  
* Experiments should be carried out in branches, and merged with the main branch only when it works and is decidedly a welcome addition to the final robot code.
