# Travel


Higher Level Diagram:
+---------------------+
|       Travel        |
+---------------------+
|                     |
| + Manage Packages   |
| + Manage Passengers |
| + Manage Activities |
| + Generate Reports  |
|                     |
+---------------------+


Lower Level Diagram (UML Class Diagram):

+----------------+       +-------------------+       +----------------+       +----------------+       +---------------------+
|  TravelPackage |<>-----|    Destination    |<>-----|    Activity    |       |    Passenger   |       |  PassangerActivitys | 
+----------------+       +-------------------+       +----------------+       +----------------+       +---------------------+
| - name         |       | - name            |       | - name         |       | - name         |       |    activity         |
| - passengerCap |       | - activities      |       | - description  |       | - passengerNum |       |    passanger        |
| -  destination |       +-------------------+       | - cost         |       | - passengerType|       |                     |
| - passengers   |                                   | - capacity     |       | - balance      |       |                     |
|                |                                   | - destination  |       |                |       |                     |
|                |                                   |                |       |                |       |                     |
+----------------+                                   +----------------+       +----------------+       +---------------------+







