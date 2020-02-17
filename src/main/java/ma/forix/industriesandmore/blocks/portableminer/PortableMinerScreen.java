package ma.forix.industriesandmore.blocks.portableminer;

import com.mojang.blaze3d.systems.RenderSystem;
import ma.forix.industriesandmore.IndustriesAndMore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftGame;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.extensions.IForgeWorldServer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.network.FMLPlayMessages;

import java.util.List;
import java.util.stream.Stream;

public class PortableMinerScreen extends ContainerScreen<PortableMinerContainer>{

    GuiScreenEvent screenEvent;

    private ResourceLocation GUI = new ResourceLocation(IndustriesAndMore.MOD_ID, "textures/gui/portable_miner_gui.png");

    Button testbutton = new Button(62, 10, 20, 10, "test", this::onPress);

    private void onPress(Button button) {
        System.out.println("ok ! 22");
    }

    public Button.IPressable onPress(){
        System.out.println("ok !");
        return Button::onPress;
    }



    public PortableMinerScreen(PortableMinerContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        drawString(Minecraft.getInstance().fontRenderer, "Burn rate: 0", 62, 10, 0x00ffff);
        this.addButton(testbutton);
    }



    @Override
    public List<? extends IGuiEventListener> children() {
        System.out.println("test123456789");
        return super.children();
    }

    @Override
    protected void handleMouseClick(Slot slot, int slotId, int mouseButton, ClickType clickType) {
        System.out.println("salut c'est moi j'ai clické");
        System.out.println("slotStack: "+slot.getStack());
        System.out.println("slotId: "+slotId);
        System.out.println("mouseButton: "+mouseButton);
        System.out.println("ClickType: "+clickType.name());
        super.handleMouseClick(slot, slotId, mouseButton, clickType);
        if (!slot.getHasStack()){
            slot.putStack(new ItemStack(Items.ACACIA_LEAVES));
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
    }
}
