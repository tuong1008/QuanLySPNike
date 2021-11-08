
INSERT [dbo].[Authorities] ([authorityType], [username]) VALUES
(N'ROLE_ADMIN', N'admin')

INSERT [dbo].[Customer] ([customerEmailAddress], [customerName], [customerPhoneNumber], [enabled], [password], [username], [billingAddressId], [cartId], [shippingAddressId]) VALUES
(N'admin@gmail.com', N'admin', N'0123456789', 1, N'123', N'admin', NULL, NULL, NULL)

