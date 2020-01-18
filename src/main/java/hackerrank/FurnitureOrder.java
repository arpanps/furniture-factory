package hackerrank;

import java.util.HashMap;
import java.util.Map.Entry;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * A map of Furniture items to order quantities
     */

    private final HashMap<Furniture, Integer> orderedFurniture;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        orderedFurniture = new HashMap<>();
    }

    @Override
    public void addToOrder(final Furniture type, final int furnitureCount) {
        orderedFurniture.put(type, orderedFurniture.getOrDefault(type, 0) + furnitureCount);
    }

    @Override
    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return orderedFurniture;
    }

    @Override
    public float getTotalOrderCost() {
        float totalOrderCost = 0.0f;
        for (Entry<Furniture, Integer> e : orderedFurniture.entrySet()) {
            int tatalUnits = e.getValue();
            float cost = e.getKey().cost();
            totalOrderCost += tatalUnits * cost;
        }
        return totalOrderCost;
    }

    @Override
    public int getTypeCount(Furniture type) {
        return orderedFurniture.getOrDefault(type, 0);
    }

    @Override
    public float getTypeCost(Furniture type) {
        if (!orderedFurniture.containsKey(type)) {
            return 0.0f;
        }
        int tatalUnits = orderedFurniture.get(type);
        return tatalUnits * type.cost();
    }

    @Override
    public int getTotalOrderQuantity() {
        return orderedFurniture.values().stream().mapToInt(Integer::intValue).sum();
    }
}