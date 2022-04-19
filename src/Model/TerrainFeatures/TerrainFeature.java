package Model.TerrainFeatures;

import Model.Terrains.Terrain;

public class TerrainFeature {
    private TerrainFeatureType myType;

    public TerrainFeatureType getMyType() {
        return myType;
    }

    public void setMyType(TerrainFeatureType myType) {
        this.myType = myType;
    }

    public TerrainFeature(TerrainFeatureType myType) {
        this.myType = myType;
    }
}
