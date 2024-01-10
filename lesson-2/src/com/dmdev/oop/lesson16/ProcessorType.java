package com.dmdev.oop.lesson16;

public enum ProcessorType implements Describable {
    BIT_32("bit-32") {
        @Override
        public String getDescription() {
            return "bit 32 description";
        }
    },
    BIT_64("bit-64") {
        @Override
        public String getDescription() {
            return "bit 64 description";
        }
    };

    private String name;

    ProcessorType(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
