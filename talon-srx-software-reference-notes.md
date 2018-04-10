## Feedback device
Defaults to Quadrature Encoder (which is what we want)
```
/* CTRE magnetic encoder relative, same as Quadrature */
talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); /* PIDLoop = 0, timeoutMs=0 */
```