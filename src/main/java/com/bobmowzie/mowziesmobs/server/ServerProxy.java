package com.bobmowzie.mowziesmobs.server;

import java.io.IOException;

import com.bobmowzie.mowziesmobs.server.entity.EntitySunstrike;
import com.bobmowzie.mowziesmobs.server.entity.barakoa.trade.Trade;
import com.google.common.base.Optional;

import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;

public class ServerProxy {
    public static final DataSerializer<Optional<Trade>> OPTIONAL_TRADE = new DataSerializer<Optional<Trade>>() {
        @Override
        public void write(PacketBuffer buf, Optional<Trade> value) {
            if (value.isPresent()) {
                Trade trade = value.get();
                buf.writeItemStackToBuffer(trade.getInput());
                buf.writeItemStackToBuffer(trade.getOutput());
                buf.writeInt(trade.getWeight());
            } else {
                buf.writeItemStackToBuffer(ItemStack.field_190927_a);
            }
        }

        @Override
        public Optional<Trade> read(PacketBuffer buf) throws IOException {
            ItemStack input = buf.readItemStackFromBuffer();
            if (input == ItemStack.field_190927_a) {
                return Optional.absent();
            }
            return Optional.of(new Trade(input, buf.readItemStackFromBuffer(), buf.readInt()));
        }

        @Override
        public DataParameter<Optional<Trade>> createKey(int id) {
            return new DataParameter<>(id, this);
        }
    };

    public void onInit() {
        DataSerializers.registerSerializer(OPTIONAL_TRADE);
    }

    public void onLateInit() {}

    public void playSunstrikeSound(EntitySunstrike strike) {}
}
