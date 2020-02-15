package be.manugame.satisfactorycraft.objects.blocks.machines;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;

import static net.minecraft.util.NonNullList.withSize;

public class TileEntityPortableMiner extends TileEntity implements IInventory, ITickable {

    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
    private String customname;

    private int miningTime;
    private int currentMiningTime;

    @Override
    public int getSizeInventory() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.inventory) {
            if (!stack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return (ItemStack)this.inventory.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {

        ItemStack itemStack = (ItemStack)this.inventory.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(stack, itemStack);
        this.inventory.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && index +1 == 1 && !flag) {
            ItemStack itemStack1 = (ItemStack)this.inventory.get(index + 1);
            this.markDirty();
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);
        this.miningTime = compound.getInteger("MiningTime");
        this.currentMiningTime = compound.getInteger("CurrentMiningTime");

        if (compound.hasKey("CustomName", 8)) this.setCustomname(compound.getString("CustomName"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("MiningTime", (short)this.miningTime);
        compound.setInteger("CurrentMiningTime", (short)this.currentMiningTime);
        ItemStackHelper.saveAllItems(compound, this.inventory);
        return compound;
    }

    public boolean isMining() {
        return this.miningTime > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }


    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        switch (id) {
            case 0:
                return this.miningTime;
            case 1:
                return this.currentMiningTime;

            default:
                return 0;
        }
    }

    @Override
    public void setField(int id, int value) {


        switch (id) {
            case 0:
                this.miningTime = value;
                break;
            case 1:
                this.currentMiningTime = value;
        }
    }

    @Override
    public int getFieldCount() {
        return 2;
    }

    @Override
    public void clear() {

        this.inventory.clear();
    }

    @Override
    public void update() {

        boolean mining = this.isMining();
        boolean flag1 = false;

        if (this.isMining()) --this.miningTime;

        if (!this.world.isRemote) {


        }

    }


    @Override
    public String getName() {
        return this.hasCustomName() ? this.customname : "container.portable_miner";
    }

    @Override
    public boolean hasCustomName() {
        return this.customname != null && !this.customname.isEmpty();
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
    }

    public void setCustomname(String customname) {
        this.customname = customname;
    }
}
