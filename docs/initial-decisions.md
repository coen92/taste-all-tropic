# Initial Decision Log
<i>This document is a prelude to the main Architectural Decision Records (ADR) log for the project.</i>

## Initial Decisions
- 5-08-2025: Constraints for contextual Entities:
  - Entities: `Drink`, `Order`, `Table`, `Customer`, `Admin`
  - Bounded Contexts: `Ordering`, `Registering to the Table`, `Completing the Order`
  - Constraints:
    - `Order` can only be placed by `Customer`
    - `Order` can be completed by `Admin`
    - `Order` contains the list of drinks (at least one) to be sent
    - `Customer` can only have one `Order` at a time, unless completed or removed
    - `Table` is additional and optional entity to aggregate `Customers` (and therefore their `Orders`); can have multiple `Customers` and `Orders` - only `Customer` can be assigned to `Table`
  - Functions:
    - displaying `Drink` menu by `Customer`
    - creating new `Order` by `Customer`
    - adding `Drink` to `Order` by `Customer`
    - removing `Drink` from `Order` by `Customer`
    - placing `Order` by `Customer`
    - displaying `Order` status by `Customer`
    - canceling `Order` by `Customer`
    - completing `Order` by `Admin`
    - displaying `Order` details by `Admin`
    - registering `Customer` to `Table` by `Customer` himself
